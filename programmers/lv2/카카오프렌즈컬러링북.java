import java.util.*;

class Solution {
    int numberOfArea = 0; //몇개의 영역이 있는가?
    int maxSizeOfOneArea = 0; //가장 큰 영역은 몇칸으로 이루어져 있는가?
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, picture, visited, picture[i][j]));
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int bfs(int p, int q, int[][] pic, boolean[][] visited, int color) {
        int count = 1;
        visited[p][q] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{p, q});

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= pic.length || ny < 0 || ny >= pic[0].length) {
                    continue;
                }

                if (!visited[nx][ny] && pic[nx][ny] == color) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        return count;
    }
}