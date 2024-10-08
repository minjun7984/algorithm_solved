import java.util.*;

public class Main {
    static int[][] board;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static int[][] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int round = 1;
        while (true) {
            n = sc.nextInt();
            if (n == 0) break; // 0 입력 시 종료

            board = new int[n][n];
            distance = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = sc.nextInt();
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
            System.out.println("Problem " + round + ": " + bfs(0, 0, n));
            round++;
        }
        sc.close();
    }

    public static int bfs(int x, int y, int n) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.offer(new int[]{x, y, board[0][0]});
        distance[x][y] = board[0][0];  // 시작점의 거리 초기화

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curX = now[0], curY = now[1], curCost = now[2];

            if (curX == n - 1 && curY == n - 1) return curCost;  // 마지막 좌표 도착 시 비용 리턴

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    int newCost = curCost + board[nx][ny];
                    if (newCost < distance[nx][ny]) {
                        distance[nx][ny] = newCost;
                        queue.offer(new int[]{nx, ny, newCost});
                    }
                }
            }
        }
        return -1;  // 도달할 수 없는 경우 (사실 이 경우는 발생하지 않음)
    }
}
