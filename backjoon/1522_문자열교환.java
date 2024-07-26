import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        //a의 개수를 새보자
        //i = a;
        int count = 0;
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') count++;
        }

        for (int i = 0; i < s.length(); i++) {
            int bCount = 0;
            for (int j = i; j < i + count; j++) {
                int index = j % s.length();
                if (s.charAt(index) == 'b') bCount++;
            }
            answer = Math.min(bCount, answer);
        }
        if (answer == Integer.MAX_VALUE) answer = 0;
        System.out.println(answer);
    }
}
