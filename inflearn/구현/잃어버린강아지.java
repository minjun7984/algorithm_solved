class Solution {
    public int solution(int[][] board) {
        int count = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int d1 = 0;
        int d2 = 0;

        int huX = 0;
        int huY = 0;

        int dogX = 0;
        int dogY = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 2) {
                    huX = i;
                    huY = j;
                } else if (board[i][j] == 3) {
                    dogX = i;
                    dogY = j;
                }
            }
        }

        while (count < 10000) {
            count++;
            int nextHuX = huX + dx[d1];
            int nextHuY = huY + dy[d1];
            int nextDogX = dogX + dx[d2];
            int nextDogY = dogY + dy[d2];

            if (nextHuX < 0 || nextHuX >= board.length || nextHuY < 0 || nextHuY >= board.length || board[nextHuX][nextHuY] == 1) {
                d1 = (d1 + 1) % 4;
            } else {
                huX = nextHuX;
                huY = nextHuY;
            }

            if (nextDogX < 0 || nextDogX >= board.length || nextDogY < 0 || nextDogY >= board.length || board[nextDogX][nextDogY] == 1) {
                d2 = (d2 + 1) % 4;
            } else {
                dogX = nextDogX;
                dogY = nextDogY;
            }

            if (huX == dogX && huY == dogY) {
                break;
            }
        }
        if (count >= 10000) return 0;
        return count;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}