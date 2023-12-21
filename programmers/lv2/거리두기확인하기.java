class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean flag;
    static boolean[][] check;
    static char[][] map;

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            flag = false;
            map = new char[5][5];

            for (int j = 0; j < 5; j++) {
                map[j] = places[i][j].toCharArray();
            }

            for (int r = 0; r < 5; r++) {
                for (int k = 0; k < 5; k++) {
                    if (map[r][k] == 'P') {
                        check = new boolean[5][5];
                        dfs(0, r, k);
                        if (flag) break;
                    }
                }
                if (flag) break;
            }
            if (flag) answer[i] = 0;
            else answer[i] = 1;
        }
        return answer;
    }

    static void dfs(int depth, int r, int k) {
        if (depth >= 2) return;
        check[r][k] = true;
        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = k + dy[i];

            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || check[nx][ny]) continue;

            //테이블이다...
            if (map[nx][ny] == 'O') {
                dfs(depth + 1, nx, ny);
            } else if (map[nx][ny] == 'P') {
                flag = true;
                return;
            } else if (map[nx][ny] == 'X') {
                continue;
            }
        }
    }
}