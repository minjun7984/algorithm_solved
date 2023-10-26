import java.util.*;
class Solution {
    public int solution(int[] nums){
        int answer = 0;
        HashSet<Integer> set =  new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for(int x : set) {
            int tmp = x;
            int count = 0;
            while(set.contains(tmp)) {
                count++;
                tmp--;
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}