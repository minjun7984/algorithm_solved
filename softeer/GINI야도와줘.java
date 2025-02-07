import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static char[][] board;
    static int taebumX, taebumY, riverX, riverY;
    static Queue<int[]> rainQueue = new LinkedList<>();
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = tmp.charAt(j);
                if (board[i][j] == '*') {
                    rainQueue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
                if (board[i][j] == 'X') {
                    riverX = i;
                    riverY = j;
                }
                if (board[i][j] == 'W') {
                    taebumX = i;
                    taebumY = j;
                }
            }
        }
        bfs();
        if (answer == Integer.MAX_VALUE) System.out.print("FAIL");
        else System.out.print(answer);
    }

    public static void bfs() {
        queue.offer(new int[]{taebumX, taebumY, 0});
        while (!queue.isEmpty()) {
            int size = rainQueue.size();
            for (int i = 0; i < size; i++) {
                int[] now = rainQueue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if (nx < 0 || ny < 0 || nx >= r || ny >= c || visited[nx][ny]) continue; //범위를 벗어나거나 방문햇다면
                    if (board[nx][ny] == 'H' || board[nx][ny] == 'X') continue; //집또는 강이라면 ㄴㄴ
                    visited[nx][ny] = true;
                    rainQueue.offer(new int[]{nx, ny});
                }
            }
            taebumMove();
        }
    }

    public static void taebumMove() {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int[] now = queue.poll();
            if (board[now[0]][now[1]] == 'H') answer = Math.min(answer, now[2]);
            for (int j = 0; j < 4; j++) {
                int nx = now[0] + dx[j];
                int ny = now[1] + dy[j];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c || visited[nx][ny] || board[nx][ny] == 'X') continue;
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, now[2] + 1});
            }
        }
    }
}
