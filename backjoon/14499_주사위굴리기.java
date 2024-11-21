import java.util.*;

class Main {
    static int n, m, x, y, k;
    static int[] dice = new int[7];
    static int[] dx = {0, 0, 0, -1, 1}; // 동 서 북 남
    static int[] dy = {0, 1, -1, 0, 0};
    static int[][] board;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt(); //
        x = in.nextInt(); //주사위
        y = in.nextInt(); //주사위
        k = in.nextInt(); //명령 개수
        board = new int[n][m];
        int[] move = new int[k];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                board[i][j] = in.nextInt();
            }
        }
        for(int i = 0; i < k; i++) {
            move[i] = in.nextInt();
        }
        //이동할때마다 주사위 윗면 출력 이동 칸이 0이면 바닥이 복사 칸에 쓰인건 0이됨
        for(int i = 0; i < k; i++) {
            //어디로 이동할까요?
            int moveCount = move[i];
            int nx = x + dx[moveCount];
            int ny = y + dy[moveCount];
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            moveDice(moveCount);

            if(board[nx][ny] == 0) {
                board[nx][ny] = dice[6];
            }
            else if(board[nx][ny] != 0) {
                dice[6] = board[nx][ny];
                board[nx][ny] = 0;
            }
            x = nx;
            y = ny;
            System.out.println(dice[1]);
        }
    }

    public static void moveDice(int dir) {
        int tmp = dice[1]; //sky
        switch (dir) {
            case 1:
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = tmp;
                break;
            case 2:
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
                break;
            case 3:
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
                break;
            case 4:
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
        }
    }
}
