import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(); //계단 수
        int[] nums = new int[a + 1];

        for (int i = 1; i <= a; i++) {
            nums[i] = in.nextInt();
        }

        int[] dp = new int[a + 1];
        dp[1] = nums[1];
        if(a > 1) dp[2] = nums[1] + nums[2];

        for (int i = 3; i <= a; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i - 1] + nums[i]);
        }
        System.out.print(dp[a]);
    }
}

