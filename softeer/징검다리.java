import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int[] nums = new int[n];
        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for(int i = 0; i < n; i++) {
            int max = 0;
            for(int j = i; j >= 0; j--) {
                if(nums[j] < nums[i]) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
        }

        for(int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.print(answer);
    }
}
