import java.util.*;

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] board, int[] s, int[] e) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int startX = s[0];
        int startY = s[1];
        int n = board.length;
        int m = board[0].length;
        int[][] cost = new int[n][m];

        for (int i = 0; i < n; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);

        pq.offer(new int[]{startX, startY, 0});
        cost[startX][startY] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            //다음이 벽이여야 멈춘다..
            if (now[2] > cost[now[0]][now[1]]) continue;
            for (int i = 0; i < 4; i++) {
                int nx = now[0];
                int ny = now[1];
                int tmp = now[2];

                while (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    nx += dx[i];
                    ny += dy[i];
                    tmp++;
                }

                nx -= dx[i];
                ny -= dy[i];
                tmp--;

                if (cost[nx][ny] > tmp) {
                    cost[nx][ny] = tmp;
                    pq.offer(new int[]{nx, ny, tmp});
                }
            }
        }
        if (cost[e[0]][e[1]] == Integer.MAX_VALUE) return -1;
        else return cost[e[0]][e[1]];
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}

