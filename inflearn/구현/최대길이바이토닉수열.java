import java.util.*;

class Solution {
    public int solution(int[] nums) {
        ArrayList<Integer> peeks = new ArrayList<>();
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1])
                peeks.add(i);
        }
        int answer = 0;

        for (int peek : peeks) {
            int left = peek;
            int right = peek;
            int count = 1;

            while (left - 1 >= 0 && nums[left] > nums[left - 1]) {
                left--;
                count++;
            }

            while (right + 1 < nums.length && nums[right] > nums[right + 1]) {
                right++;
                count++;

            }
            answer = Math.max(count, answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}