import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(stack.size() > 0 && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if(stack.isEmpty()) {
            return 1;
        }
        return answer;
    }
}