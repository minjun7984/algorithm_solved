import java.util.*;

class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        int m = board[0].length;
        int[][] cost = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
        cost[0][0] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.offer(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int dir = board[now[0]][now[1]] - 1;
            if (now[2] > cost[now[0]][now[1]]) continue;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; //범위를 벗어나면 지나간다
                if (i == dir && cost[nx][ny] > now[2]) {
                    cost[nx][ny] = now[2];
                    queue.offer(new int[]{nx, ny, now[2]});
                } else {
                    if (cost[nx][ny] > now[2] + 1) {
                        cost[nx][ny] = now[2] + 1;
                        queue.offer(new int[]{nx, ny, now[2] + 1});
                    }
                }
            }
        }
        return cost[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
    }
}