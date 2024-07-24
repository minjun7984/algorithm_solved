import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[] visited = new boolean[26];
    static int R, C;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        R = in.nextInt();
        C = in.nextInt();
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = in.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }

        visited[map[0][0]] = true;
        dfs(0, 0, 1);  // 초기 비용을 1로 설정
        System.out.println(answer);
    }

    public static void dfs(int startX, int startY, int cost) {
        answer = Math.max(answer, cost);

        for (int i = 0; i < 4; i++) {
            int nx = startX + dx[i];
            int ny = startY + dy[i];
            if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[map[nx][ny]]) {
                visited[map[nx][ny]] = true;
                dfs(nx, ny, cost + 1);
                visited[map[nx][ny]] = false;
            }
        }
    }
}
