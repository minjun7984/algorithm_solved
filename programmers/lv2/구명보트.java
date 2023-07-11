import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int left = 0;
        int right = people.length-1;

        while(left <= right) {
            if(left == right) {
                answer++;
                break;
            }
            if(people[left] + people[right] <= limit) {
                answer++;
                right--;
                left++;
            } else {
                answer++;
                right--;
            }
        }
        return answer;
    }
}