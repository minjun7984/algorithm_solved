import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int startX, startY, dir;
    static int endX, endY, endDir;
    static int[] dx = {0, 0, 1, -1}; //동 서 남 북
    static int[] dy = {1, -1, 0, 0};
    static boolean[][][] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
            }
        }

        startX = in.nextInt() - 1;
        startY = in.nextInt() - 1;
        dir = in.nextInt() - 1;
        endX = in.nextInt() - 1;
        endY = in.nextInt() - 1;
        endDir = in.nextInt() - 1;

        int answer = bfs();
        System.out.println(answer);
    }

    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startX, startY, dir, 0));
        visited[startX][startY][dir] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            //도착했는지
            if (now.x == endX && now.y == endY && now.dir == endDir) {
                return now.count;
            }
            //go
            for (int i = 1; i <= 3; i++) {
                int nx = now.x + dx[now.dir] * i;
                int ny = now.y + dy[now.dir] * i;
                //범위 벗어나는지
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                //벽이 있으면 멈춰야함
                if (map[nx][ny] == 1) break;
                //아직 방문하지 않았다면
                if (!visited[nx][ny][now.dir]) {
                    visited[nx][ny][now.dir] = true;
                    queue.offer(new Node(nx, ny, now.dir, now.count + 1));
                }
            }
            //회전할 경우를 찾자
            //왼쪽 90도 오른쪽 90도
            //동 서 남 북
            int left = 0;
            int right = 0;
            switch (now.dir) {
                case 0: left = 3; right = 2; break;
                case 1: left = 2; right = 3; break;
                case 2: left = 0; right = 1; break;
                case 3: left = 1; right = 0; break;
            }

            if (!visited[now.x][now.y][left]) {
                visited[now.x][now.y][left] = true;
                queue.offer(new Node(now.x, now.y, left, now.count + 1));
            }
            if (!visited[now.x][now.y][right]) {
                visited[now.x][now.y][right] = true;
                queue.offer(new Node(now.x, now.y, right, now.count + 1));
            }
        }
        return -1;
    }

    public static class Node {
        int x;
        int y;
        int dir;
        int count;

        Node(int x, int y, int dir, int count) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.count = count;
        }
    }
}




