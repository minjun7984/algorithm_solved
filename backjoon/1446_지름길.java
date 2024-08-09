import java.util.*;

public class Main {
    static int n;
    static int d;
    static ArrayList<int[]> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        d = in.nextInt();
        for(int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            int ren = in.nextInt();
            arr.add(new int[] {start, end, ren});
        }

        int[] dp = new int[10000];
        for(int i = 0; i < 10000; i++) {
            dp[i] = i;
        }

        for(int i = 1; i <= d; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            for(int j = 0; j < n; j++) {
                int[]tmp = arr.get(j);
                dp[tmp[1]] = Math.min(dp[tmp[1]] , dp[tmp[0]] + tmp[2]);
            }
        }
        System.out.println(dp[d]);
    }
}
