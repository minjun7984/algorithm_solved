import java.io.IOException;
import java.util.*;

public class Main {
    static int r, c;
    static char[][] board;
    static Queue<int[]> queue = new LinkedList<>();
    static Queue<int[]> go = new LinkedList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int time = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        r = in.nextInt();
        c = in.nextInt();

        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = in.next();
            for (int j = 0; j < c; j++) {
                char ch = str.charAt(j);
                board[i][j] = ch;
                if (ch == 'S') {
                    go.offer(new int[]{i, j, 0});
                }
                if (ch == '*') {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        bfs();
        System.out.println(time == Integer.MAX_VALUE ? "KAKTUS" : time);
    }

    public static void bfs() {
        while (!go.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] now = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = now[0] + dx[k];
                    int ny = now[1] + dy[k];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && board[nx][ny] == '.') {
                        board[nx][ny] = '*';
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            int duduSize = go.size();
            for (int i = 0; i < duduSize; i++) {
                int[] now = go.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = now[0] + dx[k];
                    int ny = now[1] + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                        if (board[nx][ny] == '.') {
                            board[nx][ny] = 'S';
                            go.offer(new int[]{nx, ny, now[2] + 1});
                        } else if (board[nx][ny] == 'D') {
                            time = Math.min(time, now[2] + 1);
                            return;
                        }
                    }
                }
            }
        }
    }
}