import java.util.*;

public class Main {
    static int n, m;
    static int answer;
    static int[][] board;
    static Queue<Cloud> queue = new LinkedList<>();
    static boolean[][] visited;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        answer = 0;
        board = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = in.nextInt();
            }
        }
        //구름생성
        queue.offer(new Cloud(n - 1, 0));
        queue.offer(new Cloud(n - 1, 1));
        queue.offer(new Cloud(n - 2, 0));
        queue.offer(new Cloud(n - 2, 1));

        for (int i = 0; i < m; i++) {
            int d = in.nextInt() - 1; //방향
            int s = in.nextInt(); //몇번움직여?
            moveCloud(d, s);
            destroyCloud();
            createCloud();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer += board[i][j];
            }
        }
        System.out.println(answer);
        //물의 양 계산하기

    }

    static class Cloud {
        int x;
        int y;

        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void moveCloud(int d, int s) {
        for (Cloud cloud : queue) {
            cloud.x = (n + cloud.x + dx[d] * (s % n)) % n;
            cloud.y = (n + cloud.y + dy[d] * (s % n)) % n;
            board[cloud.x][cloud.y]++;

        }
    }

    static void destroyCloud() {
        while (!queue.isEmpty()) {
            Cloud cloud = queue.poll();
            visited[cloud.x][cloud.y] = true;

            int count = 0;
            for (int i = 1; i < 8; i += 2) {
                int nx = cloud.x + dx[i];
                int ny = cloud.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (board[nx][ny] >= 1) count++;
            }
            board[cloud.x][cloud.y] += count;
        }
    }

    static void createCloud() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] >= 2 && !visited[i][j]) {
                    queue.offer(new Cloud(i, j));
                    board[i][j] -= 2;
                }
            }
        }
        visited = new boolean[n][n];
    }
}
