import java.util.*;

public class Main {
    static int[][] map;
    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {1, -1, 0, 0};
    static int M;
    static int N;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        M = in.nextInt(); // x
        N = in.nextInt(); // y
        int K = in.nextInt(); // K개를
        map = new int[M][N];

        for (int i = 0; i < K; i++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    map[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    int area = bfs(i, j);
                    arr.add(area);
                }
            }
        }
        Collections.sort(arr);
        System.out.println(arr.size());
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }

    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        map[startX][startY] = 1;
        int area = 0;

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int nowX = tmp[0];
            int nowY = tmp[1];
            area++;

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[nx][ny] != 1) {
                    queue.offer(new int[]{nx, ny});
                    map[nx][ny] = 1;
                }
            }
        }
        return area;
    }
}



