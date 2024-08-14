import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        long min = Long.MAX_VALUE;
        int left = 0;
        int right = n - 1;
        int answerLeft = left;
        int answerRight = right;

        while (left < right) {
            long sum = nums[left] + nums[right];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                answerLeft = left;
                answerRight = right;
            }
            if (sum >= 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(nums[answerLeft] + " " + nums[answerRight]);
    }
}

