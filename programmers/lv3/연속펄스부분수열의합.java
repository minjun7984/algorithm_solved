class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long[][] dp = new long[n][2];
        long max = 0;

        dp[0][0] = sequence[0];
        dp[0][1] = -1 * sequence[0];
        max = Math.max(dp[0][0], dp[0][1]);

        for(int i = 1; i < sequence.length; i++) {
            dp[i][0] = Math.max(sequence[i], dp[i-1][1] + sequence[i]);
            dp[i][1] = Math.max(-1 * sequence[i], dp[i-1][0] - sequence[i]);
            max = Math.max(dp[i][0], max);
            max = Math.max(dp[i][1], max);
        }
        return max;
    }
}