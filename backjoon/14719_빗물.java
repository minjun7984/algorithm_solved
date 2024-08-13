import java.util.*;

public class Main {
    static int h;
    static int w;
    static int[][] map;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        h = in.nextInt(); //세로
        w = in.nextInt(); //가로
        map = new int[h][w];
        int count = 0;

        for (int i = 0; i < w; i++) {
            int tmp = in.nextInt();
            for (int j = h - 1; j >= h - tmp; j--) {
                map[j][i] = 1;
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1) continue;
                if (check(i, j)) {
                    count++;
                    map[i][j] = 2;
                }
            }
        }
        System.out.print(count);
    }

    //좌 우가 막혀있거나 물이 채워져있으면 삽가능함..!
    public static boolean check(int x, int y) {
        boolean leftFlag = false;
        boolean rightFlag = false;
        int left = y;
        int right = y;

        while (left >= 0) {
            if (map[x][left] == 2) return true;
            if (map[x][left] == 1) {
                leftFlag = true;
                break;
            }
            left--;
        }
        if (leftFlag == false) return false;

        while (right < w) {
            if (map[x][right] == 2) return true;
            if (map[x][right] == 1) {
                rightFlag = true;
                break;
            }
            right++;
        }
        if (leftFlag == true && rightFlag == true) return true;
        else return false;
    }
}

