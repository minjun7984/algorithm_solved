import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max = 0;
        int[] t = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = in.nextInt();
            p[i] = in.nextInt();
        }

        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (i + t[i] <= n) {
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        System.out.print(dp[n]);
    }
}
