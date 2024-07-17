import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int len = number.length() - k;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < ch && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

        for (int i = 0; i < len; i++) {
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}