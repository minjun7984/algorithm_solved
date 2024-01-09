import java.util.*;
//멜로디에 포함되어 있는 음의 수N, 한 줄에 있는 프렛의 수 P
//멜로디의 한 음을 나타내는 두 정수가 주어진다
//줄번호 프렛번호
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int answer = 0;
        int n = in.nextInt(); //음의 개수
        int m = in.nextInt(); //프렛 개수

        Stack<Integer>[] stack = new Stack[7];
        //멜로디를 채워넣는다 => 각 줄마다 나열될 것이다.
        for(int i = 0; i < 7; i++) {
            stack[i] = new Stack<>();
        }

        for(int i = 0 ; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            while(!stack[a].isEmpty() && stack[a].peek() > b) {
                stack[a].pop();
                answer++;
            }
            if(stack[a].isEmpty() || stack[a].peek() < b) {
                stack[a].push(b);
                answer++;
            }
        }
        System.out.println(answer);
    }
}

