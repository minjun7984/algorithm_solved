import java.util.*;

class Solution {
    public static char[][] map;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public int solution(String[] maps) {
        int m = maps.length;
        int n = maps[0].length();
        map = new char[m][n];

        //시작위치
        int[] start = new int[2];
        int[] lever = new int[2];

        //for문을 돌면서 S,E,L의 위치를 찾으며 맵을 채운다.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maps[i].charAt(j) == 'S') {
                    start = new int[]{i, j};
                }
                if (maps[i].charAt(j) == 'L') {
                    lever = new int[]{i, j};
                }
                map[i][j] = maps[i].charAt(j);
            }
        }

        int startToLever = bfs(start, 'L');
        int startToEnd = bfs(lever, 'E');

        if (startToLever == -1 || startToEnd == -1) {
            return -1;
        }
        return startToLever + startToEnd;
    }

    public int bfs(int[] start, char target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        boolean[][] visited = new boolean[map.length][map[0].length];

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int count = now[2];
            visited[x][y] = true;

            if (map[x][y] == target) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && !visited[nx][ny]) {
                    if (map[nx][ny] != 'X') {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, count + 1});
                    }
                }
            }
        }
        return -1;
    }
}