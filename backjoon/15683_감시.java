import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = in.nextInt();
                if (board[i][j] != 0 && board[i][j] != 6) {
                    list.add(new int[]{i, j});
                }
            }
        }
        dfs(0, board);
        System.out.println(answer);
    }

    public static void dfs(int depth, int[][] map) {
        //cctv 모두 방향 설정해줬으면 사각지대 개수 카운트
        if (depth == list.size()) {
            int count = zeroCount(map);
            answer = Math.min(answer, count);
            return;
        }

        int[][] copyMap;
        int[] cctv = list.get(depth);

        switch (board[cctv[0]][cctv[1]]) {
            case 1:
                copyMap = copyMap(map);
                moveUp(cctv, copyMap);
                dfs(depth + 1, copyMap);

                copyMap = copyMap(map);
                moveDown(cctv, copyMap);
                dfs(depth + 1, copyMap);

                copyMap = copyMap(map);
                moveLeft(cctv, copyMap);
                dfs(depth + 1, copyMap);

                copyMap = copyMap(map);
                moveRight(cctv, copyMap);
                dfs(depth + 1, copyMap);
                break;
            case 2:
                copyMap = copyMap(map);
                moveUp(cctv, copyMap);
                moveDown(cctv, copyMap);
                dfs(depth + 1, copyMap);

                copyMap = copyMap(map);
                moveLeft(cctv, copyMap);
                moveRight(cctv, copyMap);
                dfs(depth + 1, copyMap);
                break;
            case 3:
                copyMap = copyMap(map);
                moveUp(cctv, copyMap);
                moveRight(cctv, copyMap);
                dfs(depth + 1, copyMap);

                copyMap = copyMap(map);
                moveRight(cctv, copyMap);
                moveDown(cctv, copyMap);
                dfs(depth + 1, copyMap);

                copyMap = copyMap(map);
                moveLeft(cctv, copyMap);
                moveDown(cctv, copyMap);
                dfs(depth + 1, copyMap);

                copyMap = copyMap(map);
                moveLeft(cctv, copyMap);
                moveUp(cctv, copyMap);
                dfs(depth + 1, copyMap);
                break;
            case 4:
                copyMap = copyMap(map);
                moveUp(cctv, copyMap);
                moveRight(cctv, copyMap);
                moveLeft(cctv, copyMap);
                dfs(depth + 1, copyMap);

                copyMap = copyMap(map);
                moveDown(cctv, copyMap);
                moveRight(cctv, copyMap);
                moveLeft(cctv, copyMap);
                dfs(depth + 1, copyMap);

                copyMap = copyMap(map);
                moveUp(cctv, copyMap);
                moveRight(cctv, copyMap);
                moveDown(cctv, copyMap);
                dfs(depth + 1, copyMap);

                copyMap = copyMap(map);
                moveUp(cctv, copyMap);
                moveDown(cctv, copyMap);
                moveLeft(cctv, copyMap);
                dfs(depth + 1, copyMap);
                break;
            case 5:
                copyMap = copyMap(map);
                moveUp(cctv, copyMap);
                moveDown(cctv, copyMap);
                moveRight(cctv, copyMap);
                moveLeft(cctv, copyMap);
                dfs(depth + 1, copyMap);
        }
    }

    public static int[][] copyMap(int[][] map) {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        return tmp;
    }

    public static int zeroCount(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    public static void moveUp(int[] cctv, int[][] map) {
        for (int i = cctv[0] - 1; i >= 0; i--) {
            if (map[i][cctv[1]] == 6) return;
            if (map[i][cctv[1]] != 0) continue;
            map[i][cctv[1]] = -1;
        }
    }

    public static void moveDown(int[] cctv, int[][] map) {
        for (int i = cctv[0] + 1; i < n; i++) {
            if (map[i][cctv[1]] == 6) return;
            if (map[i][cctv[1]] != 0) continue;
            map[i][cctv[1]] = -1;
        }
    }

    public static void moveLeft(int[] cctv, int[][] map) {
        for (int i = cctv[1] - 1; i >= 0; i--) {
            if (map[cctv[0]][i] == 6) return;
            if (map[cctv[0]][i] != 0) continue;
            map[cctv[0]][i] = -1;
        }
    }

    public static void moveRight(int[] cctv, int[][] map) {
        for (int i = cctv[1] + 1; i < m; i++) {
            if (map[cctv[0]][i] == 6) return;
            if (map[cctv[0]][i] != 0) continue;
            map[cctv[0]][i] = -1;
        }
    }
}
