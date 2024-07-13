import java.util.*;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();

        int index = 0;
        int answer = 0;
        for(int i = 0; i < order.length; i++) {
            stack.push(i + 1);

            while(!stack.isEmpty() && stack.peek() == order[index]) {
                stack.pop();
                index++;
                answer++;
            }
        }
        return answer;
    }
}