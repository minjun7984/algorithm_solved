import java.util.*;

class Main {
    static int n, total, answer;
    static int[][] board;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        board = new int[n][n];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = in.nextInt();
                total += board[i][j];
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int d1 = 1; d1 < n; d1++) {
                    for (int d2 = 1; d2 < n; d2++) {
                        if (x + d1 + d2 >= n) continue;
                        if (y - d1 < 0 || y + d2 >= n) continue;
                        checkVoteSection(x, y, d1, d2);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static void checkVoteSection(int x, int y, int d1, int d2) {
        boolean[][] border = new boolean[n][n];
        int[] borderSum = new int[5];
        //경계선 그리기
        for (int i = 0; i <= d1; i++) {
            border[x + i][y - i] = true;
            border[x + d2 + i][y + d2 - i] = true;
        }
        for (int i = 0; i <= d2; i++) {
            border[x + i][y + i] = true;
            border[x + d1 + i][y - d1 + i] = true;
        }
        //1번 선거구
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (border[i][j]) break;
                borderSum[0] += board[i][j];
            }
        }
        //2번 선거구
        for (int i = 0; i <= x + d2; i++) {
            for (int j = n - 1; j > y; j--) {
                if (border[i][j]) break;
                borderSum[1] += board[i][j];
            }
        }
        //3번 선거구
        for (int i = x + d1; i < n; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (border[i][j]) break;
                borderSum[2] += board[i][j];
            }
        }
        //4번 선거구
        for (int i = x + d2 + 1; i < n; i++) {
            for (int j = n - 1; j >= y - d1 + d2; j--) {
                if (border[i][j]) break;
                borderSum[3] += board[i][j];
            }
        }
        borderSum[4] = total;
        for (int i = 0; i < 4; i++) {
            borderSum[4] -= borderSum[i];
        }
        Arrays.sort(borderSum);
        answer = Math.min(answer, borderSum[4] - borderSum[0]);
        //5번 선거구
    }
}
