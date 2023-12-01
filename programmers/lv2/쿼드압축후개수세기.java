class Solution {
    static int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        int size = arr.length;
        dfs(0, 0, size, arr);
        return answer;
    }

    public static boolean check(int x, int y, int size, int[][] arr) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[x][y] != arr[i][j]) return false;
            }
        }
        return true;
    }

    public static void dfs(int startX, int startY, int size, int[][] arr) {
        if (check(startX, startY, size, arr)) {
            answer[arr[startX][startY]]++;
            return;
        }
        dfs(startX, startY, size / 2, arr);
        dfs(startX + size / 2, startY, size / 2, arr);
        dfs(startX, startY + size / 2, size / 2, arr);
        dfs(startX + size / 2, startY + size / 2, size / 2, arr);
    }
}