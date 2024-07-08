import java.util.*;

class Solution {
    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, 1, 0, -1};
    public int[][] visited;

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        visited = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int nowX = tmp[0];
            int nowY = tmp[1];
            int nowCost = tmp[2];
            if (nowX == n - 1 && nowY == m - 1) return nowCost;

            for (int k = 0; k < 4; k++) {
                int nextX = nowX + dx[k];
                int nextY = nowY + dy[k];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || maps[nextX][nextY] == 0) continue;
                if (visited[nextX][nextY] == 1) continue;
                queue.offer(new int[]{nextX, nextY, nowCost + 1});
                visited[nextX][nextY] = 1;
            }
        }
        return -1;
    }
}