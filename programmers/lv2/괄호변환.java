import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";

        if (collectString(p) == true) return p;

        answer = recursive(p);
        return answer;
    }

    public String recursive(String str) {
        if (str.equals("")) return "";

        int index = sliceString(str);
        String u = str.substring(0, index + 1);
        String v = str.substring(index + 1, str.length());

        if (collectString(u)) {
            return u + recursive(v);
        } else {
            return "(" + recursive(v) + ")" + changeString(u);
        }
    }

    //문자를 변환
    public String changeString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length() - 1; i++) {
            char ch = str.charAt(i);

            if (ch == '(') sb.append(')');
            else if (ch == ')') sb.append('(');
        }
        return sb.toString();
    }

    //u와 v로 나누기 위해 index 구하기
    public int sliceString(String str) {
        int rightBracket = 0;
        int leftBracket = 0;
        int idx = 0;

        for (char c : str.toCharArray()) {
            if (c == '(') rightBracket++;
            if (c == ')') leftBracket++;

            if (rightBracket == leftBracket) {
                break;
            }
            idx++;
        }
        return idx;
    }

    //올바른 괄호 문자열인지 확인하기
    public boolean collectString(String str) {
        Stack<Character> stack = new Stack<>();
        boolean result = true;

        for (char c : str.toCharArray()) {
            if (c == '(') stack.push(c);
            else if (c == ')' && !stack.isEmpty()) stack.pop();
        }
        if (!stack.isEmpty()) result = false;
        return result;
    }
}