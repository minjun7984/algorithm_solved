import java.util.*;
import java.util.Scanner;

class Main {
    static int n;
    static char[][] board;
    static int startX, startY, endX, endY;
    static int answer = 0;
    static int[] dx = {-1, 0, 1, 0}; //동, 서, 북, 남
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        board = new char[n][n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            String s = in.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == '#') {
                    startX = i;
                    startY = j;
                    idx++;
                }
                if (board[i][j] == '#' && idx == 1) {
                    endX = i;
                    endY = j;
                }
            }
        }
        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[3] - b[3]);
        boolean[][][] visited = new boolean[n][n][4];

        for (int i = 0; i < 4; i++) {
            queue.offer(new int[]{startX, startY, i, 0});
            visited[startX][startY][i] = true;
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == endX && endY == now[1]) {
                answer = now[3];
                return;
            }

            int nx = now[0] + dx[now[2]];
            int ny = now[1] + dy[now[2]];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == '*') continue;
            if (visited[nx][ny][now[2]]) continue;

            if (board[nx][ny] == '!') {
                queue.offer(new int[]{nx, ny, (now[2] + 3) % 4, now[3] + 1});
                queue.offer(new int[]{nx, ny, (now[2] + 1) % 4, now[3] + 1});
            }
            queue.offer(new int[]{nx, ny, now[2], now[3]});
        }
    }
}
