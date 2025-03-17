import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node> {
        int start;
        int end;
        int value;

        public Node(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int answer = 0;
        parent = new int[v + 1];

        //유니온 파인드를 위한 세팅
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }

        Queue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            pq.offer(new Node(start, end, value));
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int start = node.start;
            int end = node.end;

            int startParent = find(start);
            int endParent = find(end);

            if (startParent != endParent) {
                answer += node.value;
                union(startParent, endParent);
            }
        }
        System.out.println(answer);
    }

    public static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a != b) parent[b] = a;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}

