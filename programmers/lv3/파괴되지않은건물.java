class Solution {
    public int solution(int[][] board, int[][] skill) {
        //type 1 = > 적공격 2 => 아군회복 //r1, c1, r2 ,c2까지 범위 degree는 공격데미지
        int answer = 0;
        int[][] map = new int[board.length + 1][board[0].length + 1];
        for (int[] sk : skill) {
            int attack = sk[5];
            if (sk[0] == 1) attack = (-1 * attack);

            map[sk[1]][sk[2]] += attack;
            map[sk[1]][sk[4] + 1] += (attack * -1);
            map[sk[3] + 1][sk[2]] += (attack * -1);
            map[sk[3] + 1][sk[4] + 1] += attack;
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                map[i][j] += map[i - 1][j];
            }
        }

        for (int i = 1; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                map[j][i] += map[j][i - 1];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] + map[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}