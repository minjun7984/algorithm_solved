import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int answer = 0;
        int[] home = new int[n];

        for(int i = 0; i < n; i++) {
            home[i] = in.nextInt();
        }

        Arrays.sort(home);
        int left = 0;
        int right = home[n - 1] - home[0]; //최대간격

        while(left <= right) {
            int cnt = 1;
            int mid = (left + right) / 2;
            int pre = home[0];

            for(int i = 1; i < n; i++) {
                if(home[i] - pre >= mid) {
                    cnt++;
                    pre = home[i];
                }
            }

            if(cnt >= c) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
