import java.util.*;

public class Main {
    static int[] distance1, distance2;
    static ArrayList<ArrayList<Node>> graph, reverseGraph;
    static int n, m, x;

    public static void main(String[] args) {
        int answer = 0;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        x = in.nextInt();
        distance1 = new int[n + 1];
        distance2 = new int[n + 1];

        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            int cost = in.nextInt();
            graph.get(start).add(new Node(end, cost));
            reverseGraph.get(end).add(new Node(start, cost));
        }

        distance1 = dijkstra(graph);
        distance2 = dijkstra(reverseGraph);

        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, distance1[i] + distance2[i]);
        }

        System.out.println(answer);

    }

    public static int[] dijkstra(ArrayList<ArrayList<Node>> list) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(x, 0));

        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[x] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int now = node.end;

            for (Node nodes : list.get(now)) {
                if (dis[nodes.end] > dis[now] + nodes.cost) {
                    dis[nodes.end] = dis[now] + nodes.cost;
                    queue.offer(new Node(nodes.end, dis[nodes.end]));
                }
            }
        }
        return dis;
    }

    public static class Node implements Comparable<Node> {
        int end;
        int cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}
