import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt(); //n의 값

        for (int i = 0; i < T; i++) {
            int start = in.nextInt();
            int target = in.nextInt();

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            String[] answer = new String[10000];
            Arrays.fill(answer, "");
            queue.offer(start);
            visited[start] = true;

            while (!queue.isEmpty()) {
                int now = queue.poll();
                if (now == target) break;

                int d = (now * 2) % 10000;
                int s = now == 0 ? 9999 : now - 1;
                int l = (now % 1000) * 10 + now / 1000;
                int r = now % 10 * 1000 + now / 10;

                if (!visited[d]) {
                    queue.offer(d);
                    visited[d] = true;
                    answer[d] = answer[now] + "D";
                }
                if (!visited[s]) {
                    queue.offer(s);
                    visited[s] = true;
                    answer[s] = answer[now] + "S";
                }
                if (!visited[l]) {
                    queue.offer(l);
                    visited[l] = true;
                    answer[l] = answer[now] + "L";
                }
                if (!visited[r]) {
                    queue.offer(r);
                    visited[r] = true;
                    answer[r] = answer[now] + "R";
                }
            }
            System.out.println(answer[target]);
        }
    }
}
