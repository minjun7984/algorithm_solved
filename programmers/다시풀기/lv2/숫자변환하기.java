import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        //x기본값 n더하거나 2, 3곱하거나
        int[] dp = new int[y + 1];
        Arrays.fill(dp, 100002);
        dp[x] = 0;

        for (int i = x; i <= y; i++) {
            if (dp[i] == 100002) continue;

            if (i + n <= y) {
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            }
            if (i * 2 <= y) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }
            if (i * 3 <= y) {
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }

        }
        if (dp[y] == 100002) return -1;
        return dp[y];
    }
}