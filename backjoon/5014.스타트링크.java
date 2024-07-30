import java.util.*;

public class Main {
    static int F, S, G, U, D;
    static int[] next;
    static boolean visited[];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        F = in.nextInt(); //총 몇층?
        S = in.nextInt(); //현재
        G = in.nextInt(); //목표
        U = in.nextInt(); //위로
        D = in.nextInt(); //아래

        next = new int[]{U, -D};
        visited = new boolean[F + 1];

        Queue<Integer> queue = new LinkedList<>();
        int[] answer = new int[F + 1];
        queue.offer(S);
        answer[S] = 0;
        visited[S] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == G) {
                System.out.println(answer[now]);
                System.exit(0);
            }

            for (int i = 0; i < 2; i++) {
                int nx = now + next[i];
                if (nx < 1 || nx > F) continue;
                if (!visited[nx]) {
                    visited[nx] = true;
                    queue.offer(nx);
                    answer[nx] = answer[now] + 1;
                }
            }
        }
        System.out.print("use the stairs");
    }
}