import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static int sharkSize = 2;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static int fishCount = 0;
    static int answer = 0;
    static int eatCount = 0;
    static Queue<int[]> queue = new LinkedList<>();

    static class Fish implements Comparable<Fish> {
        int x;
        int y;
        int dis;

        public Fish(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.dis != o.dis) return this.dis - o.dis;
            else if (this.x != o.x) return this.x - o.x;
            else return this.y - o.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    queue.offer(new int[]{i, j, 0});
                    board[i][j] = 0;
                }
                if (board[i][j] != 0 && board[i][j] != 9) fishCount++;
            }
        }

        while (fishCount > 0) {
            List<Fish> fishList = dijkstra();
            if (fishList.size() == 0) break;
            Collections.sort(fishList);
            Fish fish = fishList.get(0);
            board[fish.x][fish.y] = 0;
            //먹방
            eatCount++;
            if (sharkSize == eatCount) {
                sharkSize++;
                eatCount = 0;
            }
            //물고기 감소
            fishCount--;
            //생선의 이동 더해주기
            answer += fish.dis;
            queue.offer(new int[]{fish.x, fish.y, 0});
        }
        System.out.println(answer);
    }

    private static List<Fish> dijkstra() {
        int[][] dis = new int[n][n];
        List<Fish> fishList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }

        while (!queue.isEmpty()) {
            int[] shark = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = shark[0] + dx[i];
                int ny = shark[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (board[nx][ny] > sharkSize) continue;

                if (dis[nx][ny] > shark[2] + 1) {
                    dis[nx][ny] = shark[2] + 1;
                    queue.offer(new int[]{nx, ny, shark[2] + 1});
                    if (board[nx][ny] > 0 && board[nx][ny] < sharkSize) fishList.add(new Fish(nx, ny, dis[nx][ny]));
                }
            }
        }
        return fishList;
    }
}

