import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int D = in.nextInt(); //만큼 떨어진 곳
        int P = in.nextInt(); //개수
        int[] dp = new int[D + 1]; //i길이 수도관 만들었을 때 최대 용량
        //길이
        for(int i = 0; i < P; i++) {
            int len = in.nextInt(); //길이
            int total = in.nextInt();

            for(int j = D; j > len; j--) {
                if(dp[j - len] == 0) continue;
                dp[j] = Math.max(dp[j], Math.min(dp[j - len], total));
            }
            dp[len] = Math.max(dp[len], total);
        }
        System.out.println(dp[D]);
    }
}
