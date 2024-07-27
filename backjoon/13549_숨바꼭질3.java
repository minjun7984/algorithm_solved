import java.util.*;

public class Main {
    public static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    static int N;
    static int K;
    static boolean[] visited;
    static int max = 100001;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        K = in.nextInt();

        visited = new boolean[100001];
        bfs();
        System.out.println(answer);
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(N, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            visited[now.x] = true;
            if (now.x == K) answer = Math.min(now.time, answer);

            if (now.x * 2 < max && !visited[now.x * 2]) queue.offer(new Node(now.x * 2, now.time));
            if (now.x + 1 < max && !visited[now.x + 1]) queue.offer(new Node(now.x + 1, now.time + 1));
            if (now.x - 1 >= 0 && !visited[now.x - 1]) queue.offer(new Node(now.x - 1, now.time + 1));
        }
    }
}


