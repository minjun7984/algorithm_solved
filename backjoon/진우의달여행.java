import java.util.*;

public class Main {
    static class SpaceShip {
        int x;
        int y;
        int cost;
        int dir;

        public SpaceShip(int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }

    static int[] dy = {-1, 0, 1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int answer = Integer.MAX_VALUE;
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] board = new int[n][m];
        Queue<SpaceShip> queue = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = in.nextInt();
                if (i == 0) queue.offer(new SpaceShip(i, j, tmp,  4));
                board[i][j] = tmp;
            }
        }

        while(!queue.isEmpty()) {
            SpaceShip nowShip = queue.poll();
            if(nowShip.x == n - 1) {
                answer = Math.min(nowShip.cost, answer);
            }

            for(int i = 0; i < 3; i++) {
                if(nowShip.dir == i) continue;
                int nx = nowShip.x + 1;
                int ny = nowShip.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {

                    queue.offer(new SpaceShip(nx, ny, board[nx][ny] + nowShip.cost, i));

                }
            }
        }
        System.out.println(answer);
    }
}
