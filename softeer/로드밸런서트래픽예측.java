import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long k;
    static List<List<Integer>> dag = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //서버의 개수
        k = Long.parseLong(st.nextToken()); //요청의 개수

        for (int i = 0; i <= n; i++) {
            dag.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < str.length; j++) {
                dag.get(i).add(Integer.parseInt(str[j]));
            }
        }

        List<Integer> orderList = topologicalSort(dag);
        long[] traffic = new long[n + 1];
        traffic[1] = k;

        for (int i = 0; i < n; i++) {
            int node = orderList.get(i);
            long request = traffic[node];
            List<Integer> graph = dag.get(node);

            //나가는 간선이 없다면 지나감
            if (graph.size() == 1) continue;
            long quotient = request / graph.get(0);
            long remain = request % graph.get(0);

            for (int j = 1; j < graph.size(); j++) {
                int child = graph.get(j);
                traffic[child] += quotient;
            }
            for (int j = 1; j < remain + 1; j++) {
                int child = graph.get(j);
                traffic[child] += 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(traffic[i] + " ");
        }
    }

    public static List<Integer> topologicalSort(List<List<Integer>> dag) {
        int[] indegree = calIndegree(dag);
        List<Integer> orderList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            int node = stack.pop();
            orderList.add(node);

            List<Integer> graph = dag.get(node);
            for (int i = 1; i <= graph.size() - 1; i++) {
                indegree[graph.get(i)] -= 1;
                if (indegree[graph.get(i)] == 0) {
                    stack.push(graph.get(i));
                }
            }
        }
        return orderList;
    }

    public static int[] calIndegree(List<List<Integer>> dag) {
        int[] indegree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            List<Integer> graph = dag.get(i);
            if (graph.size() == 1) continue;
            for (int j = 1; j <= graph.size() - 1; j++) {
                indegree[graph.get(j)]++;
            }
        }
        return indegree;
    }
}
