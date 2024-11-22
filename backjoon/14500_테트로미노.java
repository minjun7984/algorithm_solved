import java.util.*;

class Main {
    static int n, m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] board;
    static boolean[][] visited;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(1, board[i][j], i, j);
                visited[i][j] = false;
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int depth, int count, int x, int y) {
        if (depth == 4) {
            answer = Math.max(count, answer);
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue; //범위 벗어나면 넘어간다.
                if (!visited[nx][ny]) {
                    if (depth == 2) {
                        visited[nx][ny] = true;
                        dfs(depth + 1, count + board[nx][ny], x, y);
                        visited[nx][ny] = false;
                    }
                    visited[nx][ny] = true;
                    dfs(depth + 1, count + board[nx][ny], nx, ny);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
