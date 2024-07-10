import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            int n = in.nextInt();
            int m = (int) Math.round(in.nextDouble() * 100);
            if (n == 0 && m == 0) break;
            int[] dp = new int[m + 1];

            for (int i = 0; i < n; i++) {
                int c = in.nextInt();
                int p = (int) Math.round(in.nextDouble() * 100);
                for (int j = p; j <= m; j++) {
                    dp[j] = Math.max(dp[j], dp[j - p] + c);
                }
            }
            System.out.println(dp[m]);
        }
    }
}

