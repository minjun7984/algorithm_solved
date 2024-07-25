import java.util.Scanner;

public class Main {
    static int[][] board;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        board = new int[9][9];
        //보드를 채우자
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = in.nextInt();
            }
        }
        dfs(0, 0);
    }

    public static void dfs(int row, int col) {
        if (col == 9) {
            dfs(row + 1, 0);
            return;
        }
        //행렬이 모두 채워진다 하면 end~
        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(' ');
                }
                System.out.println(sb);
            }
            System.exit(0);
        }
        //해당 값이 0이면 가능한 숫자 탐색하자
        if (board[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (search(row, col, i)) {
                    //겹치는게 없다면? 채워야하는 대상!
                    board[row][col] = i;
                    dfs(row, col + 1);
                }
            }
            board[row][col] = 0;
            return;
        }
        dfs(row, col + 1);
    }

    //중복 확인하는 메서드
    public static boolean search(int row, int col, int value) {
        //같은 행에 있는 원소들 중 겹치는 열 원소 있는지 확인하자.
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }
        //같은 열에 있는 원소 중 겹치는게 있는가?
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }
        //3 * 3겹치는거 확인하자.
        int startX = (row / 3) * 3;
        int startY = (col / 3) * 3;

        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}

