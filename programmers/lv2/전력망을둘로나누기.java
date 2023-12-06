import java.util.ArrayList;

class Solution {
    static ArrayList<Integer>[] graph;
    static int min;

    public int solution(int n, int[][] wires) {
        //n은 송전탑의 개수
        graph = new ArrayList[n + 1];
        min = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            boolean[] visited = new boolean[n + 1];

            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));

            int cnt = dfs(1, visited);
            //두개의 전력망이 가진 송전탑의 개수(절대값)
            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(min, diff);

            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        return min;
    }

    static int dfs(int start, boolean[] visited) {
        visited[start] = true;
        int cnt = 1;

        for (int nx : graph[start]) {
            if (!visited[nx]) {
                cnt += dfs(nx, visited);
            }
        }
        return cnt;
    }
}