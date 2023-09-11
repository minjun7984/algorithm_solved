class Solution {
    public static int[] dp;

    public int solution(int n) {
        //가로 길이가 2이고 세로 길이가 1인 직사각형이 있다 이
        //세로 길이 2이고 가로 n인 바닥을 가득채우려 함
        int answer = 0;
        dp = new int[600001];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }

        return dp[n];
    }
}