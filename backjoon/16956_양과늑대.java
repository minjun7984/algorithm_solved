import java.util.*;

public class Main {
    static int r, c;
    static char[][] board;
    static Queue<int[]> queue = new LinkedList<>();
    static boolean flag = true;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        r = in.nextInt();
        c = in.nextInt();
        board = new char[r][c];

        for (int i = 0; i < r; i++) {
            String str = in.next();
            for (int j = 0; j < c; j++) {
                char c = str.charAt(j);
                if (c == 'W') queue.offer(new int[]{i, j});
                board[i][j] = c;
            }
        }
        bfs();
        if(!flag) {
            System.out.print(0);
            System.exit(0);
        }

        System.out.println(1);
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (board[nx][ny] == '.') {
                        board[nx][ny] = 'D';
                    }
                    if (board[nx][ny] == 'S') {
                        flag = false;
                        return;
                    }
                }
            }
        }
    }
}