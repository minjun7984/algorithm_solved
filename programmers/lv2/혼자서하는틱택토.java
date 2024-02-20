class Solution {
    public int solution(String[] board) {
        int flag = 1;
        int xCount = 0;
        int oCount = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i].charAt(j);
                if (c == 'O') oCount++;
                if (c == 'X') xCount++;
            }
        }
        int oCheck = check(board, 'O');
        int xCheck = check(board, 'X');

        if (xCount > oCount || oCount - xCount > 1) return 0;
        if (oCheck == 1 && xCheck == 1) return 0;
        if (oCheck == 1 && xCount == oCount) return 0;
        if (xCheck == 1 && xCount + 1 == oCount) return 0;
        return flag;
    }

    public int check(String[] board, char ch) {
        //가로 확인
        for (int i = 0; i < board.length; i++) {
            if (board[i].charAt(0) == ch && board[i].charAt(1) == ch && board[i].charAt(2) == ch) {
                return 1;
            }
        }
        //세로 확인
        for (int i = 0; i < 3; i++) {
            if (ch == board[0].charAt(i) && ch == board[1].charAt(i) && ch == board[2].charAt(i)) {
                return 1;
            }
        }
        //대각 확인
        if (board[0].charAt(0) == ch && board[1].charAt(1) == ch && board[2].charAt(2) == ch) {
            return 1;
        }
        if (board[0].charAt(2) == ch && board[1].charAt(1) == ch && board[2].charAt(0) == ch) {
            return 1;
        }
        return 0;
    }
}