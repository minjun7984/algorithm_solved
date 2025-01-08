import java.util.*;

class Main {
    static int n, m;
    static int[][] board;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<int[]> queue = new LinkedList<>();
    static int year = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = in.nextInt();
                if (board[i][j] != 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        bfs();
    }
    static void bfs() {
        Queue<int[]> zeroQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            year++;
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                int count = 0;
                for (int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if (board[nx][ny] == 0) count++;
                }
                if (board[now[0]][now[1]] - count > 0) {
                    board[now[0]][now[1]] -= count;
                    queue.offer(new int[]{now[0], now[1]});
                } else {
                    zeroQueue.offer(new int[]{now[0], now[1]});
                }
            }
            while (!zeroQueue.isEmpty()) {
                int[] now = zeroQueue.poll();
                board[now[0]][now[1]] = 0;
            }

            int result = isSeparated();
            if (result == 0) {
                year = 0;
                System.out.println(year);
                System.exit(0);
            }
            if (result >= 2) {
                System.out.println(year);
                System.exit(0);
            }
        }
    }

    static int isSeparated() {
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] != 0) {
                    dfs(i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && board[nx][ny] != 0) {
                dfs(nx, ny, visited);
            }
        }
    }
}
