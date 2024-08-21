import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, l, r;
    static int[][] a;
    static ArrayList<Node> list = new ArrayList<>();
    static boolean flag;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        move();
        System.out.println(count);
    }

    static void move() {
        while (true) {
            flag = false;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            if (!flag) break;
            else count++;
        }
    }

    static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new Node(x, y));
        list.add(new Node(x, y));
        int sum = a[x][y];

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    int diff = Math.abs(a[now.x][now.y] - a[nx][ny]);
                    if (l <= diff && diff <= r) {
                        visited[nx][ny] = true;
                        sum += a[nx][ny];
                        queue.offer(new Node(nx, ny));
                        list.add(new Node(nx, ny));
                        flag = true;
                    }
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            Node tmp = list.get(i);
            a[tmp.x][tmp.y] = sum / list.size();
        }
        list = new ArrayList<>();
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}