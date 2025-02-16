import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[n][n][2];
        dp[0][0][0] = board[0][0];
        dp[0][0][1] = board[0][0] * 2;

        for(int i = 1; i < n; i++) {
            dp[0][i][0] = dp[0][i -1][0] + board[0][i];
            dp[0][i][1] = Math.max(dp[0][i -1][1], dp[0][i][0]) + board[0][i];
        }

        for(int i = 1; i< n; i++) {
            dp[i][0][0] = dp[i - 1][0][0] + board[i][0];
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i][0][0]) + board[i][0];
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]) + board[i][j];
                dp[i][j][1] = Math.max(Math.max(dp[i - 1][j][1], dp[i][j - 1][1]), dp[i][j][0]) + board[i][j];
            }
        }
        System.out.print(dp[n - 1][n - 1][1]);
    }
}
