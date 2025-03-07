import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Point {
        int x;
        int y;
        int idx;

        public Point(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }

    public static class Node implements Comparable<Node> {
        int x;
        int y;
        double value;

        public Node(int x, int y, double value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if (value < o.value) return -1;
            else return 1;
        }
    }

    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        List<Point> points = new ArrayList<>();
        List<Node> list = new ArrayList<>();
        double answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y, i));
        }

        parent = new int[n + 1];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(points.get(x - 1).idx, points.get(y - 1).idx);
        }


        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dis = distance(points.get(i), points.get(j));
                list.add(new Node(i, j, dis));
            }
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            if (find(node.x) != find(node.y)) {
                union(node.x, node.y);
                answer += node.value;
            }
        }
        System.out.println(String.format("%.2f", answer));
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
}
