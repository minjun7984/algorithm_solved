import java.util.*;

class Solution {
    static List<ArrayList<Integer>> graph = new ArrayList<>();

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < wires.length; i++) {
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }

        for (int i = 0; i < wires.length; i++) {
            int first = wires[i][0];
            int second = wires[i][1];
            graph.get(first).remove(Integer.valueOf(second));
            graph.get(second).remove(Integer.valueOf(first));

            boolean[] visited = new boolean[n + 1];

            int count = dfs(first, visited);
            int dif = Math.abs(count - (n - count));
            answer = Math.min(dif, answer);

            graph.get(first).add(second);
            graph.get(second).add(first);
        }
        return answer;
    }

    private int dfs(int start, boolean[] visited) {
        visited[start] = true;
        int count = 1;

        for (int x : graph.get(start)) {
            if (!visited[x]) {
                count += dfs(x, visited);
            }
        }
        return count;
    }
}