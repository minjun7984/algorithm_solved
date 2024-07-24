import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] dp = new int[100001][4];

        dp[1][1] = 1; //1

        dp[2][1] = 1; // 1 + 1
        dp[2][2] = 1;// 2

        dp[3][1] = 1; // 1 + 1 + 1
        dp[3][2] = 1; // 1 + 2
        dp[3][3] = 1; // 3

        for (int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }

        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int sum = dp[n][1] + dp[n][2] + dp[n][3];
            System.out.println(sum);
        }
    }
}

