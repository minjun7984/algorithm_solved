import java.util.*;

public class Main {
    static int n, k, l;
    static int[][] board;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int time = 0;
    static HashMap<Integer, Character> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        board = new int[n][n];
        //사과 위치
        for(int i = 0; i < k; i++) {
            int x = in.nextInt() -1;
            int y = in.nextInt() -1;
            board[x][y] = 2;
        }
        //뱀의 방향 정보
        l = in.nextInt();
        for(int i = 0; i < l; i++) {
            int second = in.nextInt();
            char d = in.next().charAt(0);
            map.put(second, d);
        }
        move();
        System.out.println(time);
    }

    private static void move() {
        int x = 0;
        int y = 0;
        int dir = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        board[x][y] = 1;

        while(true) {
            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            //범위를 넘어가면 out
            if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
                break;
            }
            //몸통에 닿으면 out
            if(board[nx][ny] == 1) break;
            if(board[nx][ny] == 0) {
                int[] tail = queue.poll();
                board[tail[0]][tail[1]] = 0;
            }

            //회전회오리
            if(map.containsKey(time)) {
                if (map.get(time) == 'D') {
                    dir = (dir + 3) % 4;
                } else {
                    dir = (dir + 1) % 4;
                }
            }
            board[nx][ny] = 1;
            queue.offer(new int[] {nx, ny});
            x = nx;
            y = ny;
        }
    }
}




