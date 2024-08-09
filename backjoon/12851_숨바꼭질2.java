import java.util.*;

public class Main {
    static int n;
    static int k;
    static int[] visited;
    static int min = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        visited = new int[100001];
        if (n >= k) {
            System.out.println(n - k);
            System.out.println(1);
            System.exit(0);
            return;
        }

        bfs(n, k);

        System.out.println(visited[k]);
        System.out.println(count);
    }

    public static void bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (visited[now] > min) return;

            for (int nx : new int[]{now - 1, now + 1, now * 2}) {
                if (nx < 0 || nx >= visited.length) continue;

                if (nx == k) {
                    min = visited[now];
                    count++;
                }

                if (visited[nx] == 0 || visited[nx] == visited[now] + 1) {
                    queue.offer(nx);
                    visited[nx] = visited[now] + 1;
                }
            }
        }
    }
}
