import java.io.*;
import java.util.*;

public class Main {
    static int h, w, q;
    static int[][] board;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        board = new int[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < w; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startX = Integer.parseInt(st.nextToken()) - 1;
            int startY = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken());
            bfs(startX, startY, value);
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int startX, int startY, int value) {
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[h][w];

        visited[startX][startY] = true;
        int x = board[startX][startY]; //현재위치의 밸류
        board[startX][startY] = value; //방문 처리
        queue.offer(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= h || ny >= w || visited[nx][ny]) continue;
                if (board[nx][ny] == x) {
                    visited[nx][ny] = true;
                    board[nx][ny] = value;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
