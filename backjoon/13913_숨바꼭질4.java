import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int[] visited;
    static int[] parent;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        visited = new int[100001];
        parent = new int[100001];

        bfs();
        System.out.println(visited[k]);

        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        int index = k;
        while (index!=n){
            stack.push(parent[index]);
            index = parent[index];
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb.toString());
    }


    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            if(now == k) {
                break;
            }
            for(int nx : new int[] {now -1, now + 1, now * 2}) {
                if(nx < 0 || nx > 100000) continue;

                if(visited[nx] == 0) {
                    queue.offer(nx);
                    visited[nx] = visited[now] + 1;
                    parent[nx] = now;
                }
            }
        }
    }
}
