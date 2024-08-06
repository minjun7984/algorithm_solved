import java.util.*;

public class Main {
    static int n, d, k, c;
    static int[] belt;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //임의 한 위치부터 k개 접시를 연속해서 먹을 경우 할인가격 제공
        //초밥 조류 쿠폰 발행 1번행사에 참여할 경우 무료제공 없으면 만들어서줘
        n = in.nextInt(); //접시수
        d = in.nextInt(); //가짓수
        k = in.nextInt(); //연속해서 먹는 접시의 수;
        c = in.nextInt(); //쿠폰번호

        belt = new int[n];

        for (int i = 0; i < n; i++) {
            belt[i] = in.nextInt();
        }

        int[] check = new int[d + 1];
        int count = 0;
        int max = 0;

        for (int i = 0; i < k; i++) {
            if (check[belt[i]] == 0) count++;
            check[belt[i]]++;
        }

        for (int i = 0; i < n; i++) {
            if(max <= count) {
                if(check[c] == 0) max = count + 1;
                else max = count;
            }
            int end = (i + k) % n;
            if(check[belt[end]] ++ == 0) count++;
            if(--check[belt[i]] == 0) count--;
        }
        System.out.print(max);
    }
}
