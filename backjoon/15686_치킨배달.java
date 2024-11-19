import java.util.*;

class Main {
    static int n, m;
    static int[][] board;
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<int[]> homeList = new ArrayList<>();
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = in.nextInt();
                if (tmp == 2) list.add(new int[]{i, j});
                if (tmp == 1) homeList.add(new int[]{i, j});
                board[i][j] = tmp;
            }
        }
        visited = new boolean[list.size()];
        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int depth, int start) {
        if (depth == m) {
            int cal = calculateValue();
            answer = Math.min(answer, cal);
            return;
        } else {
            for (int i = start; i < list.size(); i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(depth + 1, i + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static int calculateValue() {
        int total = 0;
        for (int i = 0; i < homeList.size(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < list.size(); j++) {
                if (visited[j]) {
                    int[] chickenLocation = list.get(j);
                    min = Math.min(min, Math.abs(chickenLocation[0] - homeList.get(i)[0]) + Math.abs(chickenLocation[1] - homeList.get(i)[1]));
                }
            }
            total += min;
        }
        return total;
    }
}
