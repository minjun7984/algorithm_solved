class Solution {
    int[] visited;
    static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new int[dungeons.length];

        dfs(0, k, dungeons);

        return answer;
    }

    public void dfs(int depth, int total, int[][] dungeons) {
        answer = Math.max(depth, answer);

        for (int i = 0; i < dungeons.length; i++) {
            if (total < dungeons[i][0] || visited[i] == 1) continue;
            visited[i] = 1;
            total -= dungeons[i][1];
            dfs(depth + 1, total, dungeons);
            visited[i] = 0;
            total += dungeons[i][1];
        }
    }
}