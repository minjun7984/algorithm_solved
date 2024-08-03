import java.util.*;

public class Main {
    static int n, k;
    static int[] belt;
    static boolean[] robot;
    static int answer = 0;
    static int len;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt(); //k개이상이면 종료
        belt = new int[n * 2];
        robot = new boolean[n];
        len = belt.length;

        for (int i = 0; i < len; i++) {
            belt[i] = in.nextInt();
        }

        while (check()) {
            answer++;
            //1. 벨트가 로봇이랑 함께 회전하자!
            rotateBeltAndRobots();
            //가장먼저 올라간 로봇부터 벨트가 회전하는 방향으로 이동할 수 있다면 이동
            for (int i = robot.length - 1; i > 0; i--) {
                if (robot[i - 1] && belt[i] > 0 && !robot[i]) {
                    belt[i]--;
                    robot[i] = true;
                    robot[i - 1] = false;
                }
            }
            if (belt[0] > 0) {
                robot[0] = true;
                belt[0]--;
            }
        }
        System.out.print(answer);
    }

    public static void rotateBeltAndRobots() {
        int last = belt[len - 1];
        for (int i = len - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }

        for (int i = robot.length - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        belt[0] = last;
        robot[0] = false;
        robot[robot.length - 1] = false;
    }

    public static boolean check() {
        int count = 0;
        for (int i = 0; i < belt.length; i++) {
            if (belt[i] == 0) count++;
            if (count >= k) {
                return false;
            }
        }
        return true;
    }
}