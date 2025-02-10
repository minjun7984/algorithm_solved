import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] token = new int[n + 1];
        int[] dp = new int[k + 1];

        for (int i = 1; i <= n; i++) {
            token[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= k; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = token[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - token[i]] + 1);
            }
        }
        if (dp[k] == Integer.MAX_VALUE - 1) System.out.print(-1);
        else System.out.print(dp[k]);

    }
}
