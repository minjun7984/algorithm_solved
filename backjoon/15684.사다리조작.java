import java.util.*;

public class Main {
    static int n; //세로선
    static int m; //가로선
    static int h; //세로선마다 가로선 넣을 수 있는 위치의 개수
    static int[][] board;

    //b번 세로선과 b+1번 세로선을 a번 점선 위치에서 연결했다
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        h = in.nextInt();
        board = new int[h + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            board[a][b] = 1; //우측으로 연결
            board[a][b + 1] = 2; //좌측으로 연결
        }

        for (int i = 0; i <= 3; i++) {
            dfs(1, 0, i);
        }
        System.out.print(-1);
    }

    public static void dfs(int startX, int count, int ladderCount) {
        if (ladderCount == count) {
            if (check()) {
                System.out.print(ladderCount);
                System.exit(0);
            }
            return;
        }

        for (int i = startX; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                if (board[i][j] == 0 && board[i][j + 1] == 0) { //연결할 수 있다면?
                    board[i][j] = 1;
                    board[i][j + 1] = 2;
                    dfs(i, count + 1, ladderCount);
                    board[i][j] = 0;
                    board[i][j + 1] = 0;
                }
            }
        }
    }

    //i로 출발해 i로 돌아올 수 있는지 췤!
    private static boolean check() {
        for (int i = 1; i <= n; i++) {
            int ny = i;
            for (int nx = 1; nx <= h; nx++) {
                if (board[nx][ny] == 1) ny++;
                else if (board[nx][ny] == 2) ny--;
            }
            if (ny != i) return false;
        }
        return true;
    }
}