class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][4];

        for (int i = 0; i < land.length; i++) {
            dp[i][0] = land[i][0];
            dp[i][1] = land[i][1];
            dp[i][2] = land[i][2];
            dp[i][3] = land[i][3];
        }

        for (int i = 1; i < land.length; i++) {
            dp[i][0] += Math.max(Math.max(dp[i - 1][1], dp[i - 1][2]), dp[i - 1][3]);
            dp[i][1] += Math.max(Math.max(dp[i - 1][0], dp[i - 1][2]), dp[i - 1][3]);
            dp[i][2] += Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][3]);
            dp[i][3] += Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(dp[land.length - 1][i], answer);
        }
        return answer;
    }
}