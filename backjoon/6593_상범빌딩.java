import java.util.*;

public class Main {
    static int l; //층 수
    static int r; //한 층의 행
    static int c; //한 층의 열
    static char[][][] board;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int startX, startY, startZ;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            l = in.nextInt();
            r = in.nextInt();
            c = in.nextInt();
            board = new char[l][r][c];
            if (l == 0 && r == 0 && c == 0) return;

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String str = in.next();
                    for (int k = 0; k < c; k++) {
                        board[i][j][k] = str.charAt(k);
                        if (str.charAt(k) == 'S') {
                            startX = j;
                            startY = k;
                            startZ = i;
                        }
                    }
                }
                in.nextLine();
            }
            bfs(startZ, startX, startY);
        }
    }

    public static void bfs(int z, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[l][r][c];
        queue.offer(new int[]{z, x, y, 0});
        visited[z][x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (board[now[0]][now[1]][now[2]] == 'E') {
                System.out.println("Escaped in " + now[3] + " minute(s).");
                return;
            }

            for (int i = 0; i < 6; i++) {
                int nx = now[1] + dx[i];
                int ny = now[2] + dy[i];
                int nz = now[0] + dz[i];

                if (nz >= 0 && nx >= 0 && ny >= 0 && nz < l && nx < r && ny < c && board[nz][nx][ny] != '#') {
                    if (!visited[nz][nx][ny]) {
                        visited[nz][nx][ny] = true;
                        queue.offer(new int[]{nz, nx, ny, now[3] + 1});
                    }
                }
            }
        }
        System.out.println("Trapped!");
    }
}