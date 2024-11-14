import java.util.*;

public class Main {
    static int n, m, k;
    static Queue<FireBall> queue = new LinkedList<>();
    static ArrayList<FireBall>[][] board;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};    //방향 r값 변경값
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int answer = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt(); //파이어볼
        k = in.nextInt(); //
        board = new ArrayList[n][n];
        //각 배열 위치에 파이어볼 기록
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            int r = in.nextInt() - 1;
            int c = in.nextInt() - 1;
            int m = in.nextInt();
            int s = in.nextInt();
            int d = in.nextInt();
            queue.offer(new FireBall(r, c, m, s, d));
        }
        for (int i = 0; i < k; i++) {
            moveFireBall();
            checkFireBall();
        }

        while (!queue.isEmpty()) {
            FireBall now = queue.poll();
            answer += now.m;
        }
        System.out.println(answer);
    }

    public static void moveFireBall() {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            FireBall now = queue.poll();
            //파이어볼이 자신의 방향 d로 s칸만큼 이동한다.
            int nr = (now.r + n + dr[now.d] * (now.s % n)) % n;
            int nc = (now.c + n + dc[now.d] * (now.s % n)) % n;
            now.r = nr;
            now.c = nc;
            board[nr][nc].add(now);
        }
    }

    public static void checkFireBall() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //같은칸에 파이어볼이 2개 이상? 4개로 분열하자
                int mSum = 0;
                int sSum = 0;
                int oddSum = 0;
                int evenSum = 0;
                int size = board[i][j].size();
                if (size >= 2) {
                    for (FireBall now : board[i][j]) {
                        mSum += now.m;
                        sSum += now.s;
                        if (now.d % 2 == 1) oddSum++;
                        if (now.d % 2 == 0) evenSum++;
                    }
                    board[i][j].clear();
                    if (mSum / 5 == 0) continue; //질량이 0이면 소멸
                    //모두 홀수이면
                    if (oddSum == 0 || evenSum == 0) {
                        for (int l = 0; l < 8; l += 2) {
                            queue.offer(new FireBall(i, j, mSum / 5, sSum / size, l));
                        }
                    } else {
                        for (int l = 1; l < 8; l += 2) {
                            queue.offer(new FireBall(i, j, mSum / 5, sSum / size, l));
                        }
                    }
                } else if (size == 1) {
                    queue.offer(board[i][j].get(0));
                    board[i][j].clear();
                }
            }
        }
    }

    public static class FireBall {
        int r;
        int c;
        int m;
        int s;
        int d;

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}

