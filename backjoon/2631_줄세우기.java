import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        int[] dp = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            for(int j = i - 1;  j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(n - max);
    }
}
