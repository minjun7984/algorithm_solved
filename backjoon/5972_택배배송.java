import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] costs;
    static ArrayList<ArrayList<Node>> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st= new StringTokenizer(in.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr.get(start).add(new Node(end, cost));
            arr.get(end).add(new Node(start, cost));
        }
        dijkstra();
        System.out.println(costs[n]);
    }

    public static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        queue.offer(new Node(1, 0));
        costs[1] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (Node next : arr.get(now.x)) {
                if (costs[now.x] + next.cost < costs[next.x]) {
                    costs[next.x] = costs[now.x] + next.cost;
                    queue.offer(new Node(next.x, costs[next.x]));
                }
            }
        }
    }

    public static class Node {
        int x;
        int cost;

        public Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }
}

