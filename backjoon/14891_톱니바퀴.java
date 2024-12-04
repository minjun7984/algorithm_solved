import java.util.*;

class Main {
    static int[][] wheel;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        wheel = new int[5][8];

        for (int i = 1; i <= 4; i++) {
            String s = in.next();
            for (int j = 0; j < s.length(); j++) {
                wheel[i][j] = s.charAt(j) - '0';
            }
        }

        int k = in.nextInt();

        for (int i = 0; i < k; i++) {
            int num = in.nextInt();
            int dir = in.nextInt();
            int[] rotateValue = new int[5];
            rotateValue[num] = dir;

            for (int j = num - 1; j > 0; j--) {
                if (wheel[j + 1][6] == wheel[j][2]) break;
                else {
                    rotateValue[j] = rotateValue[j + 1] * -1;
                }
            }
            for (int j = num + 1; j < 5; j++) {
                if (wheel[j - 1][2] == wheel[j][6]) break;
                else {
                    rotateValue[j] = rotateValue[j - 1] * -1;
                }
            }
            for (int j = 1; j <= 4; j++) {
                rotate(rotateValue[j], j);
            }
        }
        int answer = 0;
        if (wheel[1][0] == 1) answer += 1;
        if (wheel[2][0] == 1) answer += 2;
        if (wheel[3][0] == 1) answer += 4;
        if (wheel[4][0] == 1) answer += 8;
        System.out.println(answer);
    }

    static void rotate(int dir, int num) {
        if (dir == 0) return;
        if (dir == 1) {
            int tmp = wheel[num][7];
            for (int i = 6; i >= 0; i--) {
                wheel[num][i + 1] = wheel[num][i];
            }
            wheel[num][0] = tmp;
        }
        if (dir == -1) {
            int tmp = wheel[num][0];
            for (int i = 0; i <= 6; i++) {
                wheel[num][i] = wheel[num][i + 1];
            }
            wheel[num][7] = tmp;
        }
    }
}
