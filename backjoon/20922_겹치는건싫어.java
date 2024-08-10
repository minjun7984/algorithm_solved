import java.util.*;

public class Main {
    static int n;
    static int k;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt(); //ㄱㅐ 중복 가능
        int[] nums = new int[100001];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int answer = 0;
        int left = 0;
        int right = 0;

        while (right < arr.length) {
            while (right < arr.length && nums[arr[right]] + 1 <= k) {
                nums[arr[right]]++;
                right++;
            }
            int len = right - left;
            answer = Math.max(len, answer);
            nums[arr[left]]--;
            left++;
        }
        System.out.println(answer);
    }
}
