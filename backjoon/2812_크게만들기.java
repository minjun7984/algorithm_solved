import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); //n자리
        int K = in.nextInt(); //K개를 지워서 얻을 수 있는 가장 큰 수
        String num = in.next();
        Stack<Character> stack = new Stack<>();

        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < c && K > 0) {
                stack.pop();
                K--;
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < stack.size() - K; i++) {
            sb.append(stack.get(i));
        }
        System.out.println(sb);
    }
}
