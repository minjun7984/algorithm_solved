import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int[][] visited;

    public int solution(int[][] board) {
        visited = new int[7][7];
        bfs(new int[]{0, 0}, board);
        if (visited[6][5] == 0 && visited[5][6] == 0) return -1;
        else return visited[6][6];
    }

    public void bfs(int[] start, int[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        int L = 0;

        while (!queue.isEmpty()) {
            L++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] tmp = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = tmp[0] + dx[j];
                    int ny = tmp[1] + dy[j];
                    if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[nx][ny] == 0 && visited[nx][ny] == 0) {
                        visited[nx][ny] = L;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] arr = {{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0}};
        System.out.println(T.solution(arr));
    }
}