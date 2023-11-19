import java.util.*;

class Solution {
    public String solution(String s) {
        Stack<String> stack = new Stack<>();
        String answer = "";

        for (Character c : s.toCharArray()) {
            if (c == ')') {
                String tmp = "";

                while (!stack.empty()) {
                    String ch = stack.pop();
                    if (ch.equals("(")) {
                        String num = "";
                        while (!stack.empty() && Character.isDigit(stack.peek().charAt(0))) {
                            num = stack.pop() + num;
                        }

                        String res = "";
                        int cnt = 0;
                        if (num.equals("")) cnt = 1;
                        else cnt = Integer.parseInt(num);

                        for (int i = 0; i < cnt; i++) {
                            res += tmp;
                        }
                        stack.push(res);
                        break;
                    }
                    tmp = ch + tmp;
                }
            } else stack.push(String.valueOf(c));
        }
        for (String x : stack) {
            answer += x;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}