import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); //물품 수
        int K = in.nextInt(); //버틸 수 있는 무게
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            int W = in.nextInt(); //무게
            int V = in.nextInt(); //가치
            for (int j = 1; j <= K; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - W >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - W] + V);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}