import java.util.*;

class Solution {
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int oilMapCnt = 1;
    int[][] oilMap;
    HashMap<Integer, Integer> map = new HashMap<>();

    public int solution(int[][] land) {
        //0이면 빈 땅 1이면 석유가 있는땅! bfs로 풀어보자 @_@
        int answer = 0;
        visited = new boolean[land.length][land[0].length];
        oilMap = new int[land.length][land[0].length];

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] != 0 && visited[i][j] != true) {
                    int cnt = bfs(i, j, land);
                    map.put(oilMapCnt, cnt);
                    oilMapCnt++;
                }
            }
        }

        int[] oilSum = new int[land[0].length];

        for (int i = 0; i < land[0].length; i++) {
            Set<Integer> set = new HashSet<>();

            for (int j = 0; j < land.length; j++) {
                if (land[j][i] == 1) {
                    set.add(oilMap[j][i]);
                }
            }

            for (int key : set) {
                oilSum[i] += map.get(key);
            }
        }

        for (int i = 0; i < land[0].length; i++) {
            answer = Math.max(answer, oilSum[i]);
        }
        return answer;
    }

    public int bfs(int p, int q, int[][] land) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 1;
        visited[p][q] = true;
        oilMap[p][q] = oilMapCnt;
        queue.offer(new int[]{p, q});

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if (nx >= 0 && nx < land.length && ny >= 0 && ny < land[0].length && !visited[nx][ny] && land[nx][ny] != 0) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    oilMap[nx][ny] = oilMapCnt;
                    count++;
                }
            }
        }
        return count;
    }
}