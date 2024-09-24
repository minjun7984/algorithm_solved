import java.util.Scanner;

public class Main {
    static int leftArms = 0, rightArms = 0, leftLeg = 0, rightLeg = 0, center = 0;
    static int heartX, heartY;
    static char[][] board;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        board = new char[n + 1][n + 1];
        //쿠키보드 만들기
        for (int i = 0; i < n; i++) {
            String str = in.next();
            board[i] = str.toCharArray();
        }
        //심장구하기
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (flag) break;
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '*') {
                    heartX = i + 1;
                    heartY = j;
                    flag = true;
                    break;
                }
            }
        }
        //왼팔
        int leftIdx = heartY - 1;
        while (leftIdx >= 0 && board[heartX][leftIdx] == '*') {
            leftArms++;
            leftIdx--;
        }
        //오른팔
        int rightIdx = heartY + 1;
        while (rightIdx < n && board[heartX][rightIdx] == '*') {
            rightArms++;
            rightIdx++;
        }
        //몸통길이
        int centerIdx = heartX + 1;
        while (centerIdx < n && board[centerIdx][heartY] == '*') {
            center++;
            centerIdx++;
        }

        int leftLegIdx = centerIdx;
        while (leftLegIdx < n && board[leftLegIdx][heartY - 1] == '*') {
            leftLeg++;
            leftLegIdx++;
        }

        int rightLegIdx = centerIdx;
        while (rightLegIdx < n && board[rightLegIdx][heartY + 1] == '*') {
            rightLeg++;
            rightLegIdx++;
        }
        System.out.println((heartX + 1) + " " + (heartY + 1));
        System.out.println(leftArms + " " + rightArms + " " + center + " " + leftLeg + " " + rightLeg);
    }
}

