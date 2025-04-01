import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] appMemory = new int[n];
        int[] appCost = new int[n];
        int sum = 0;
        //앱의 메모리
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            appMemory[i] = Integer.parseInt(st.nextToken());
        }
        //비활할 경우의 비용 비용을 최소화해서 m을 확보해야
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            appCost[i] = Integer.parseInt(st.nextToken());
            sum += appCost[i];
        }

        int[] dp = new int[sum + 1];

        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= appCost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - appCost[i]] + appMemory[i]);
            }
        }

        for (int i = 0; i < sum + 1; i++) {
            if (dp[i] >= m) {
                System.out.print(i);
                break;
            }
        }
    }
}
