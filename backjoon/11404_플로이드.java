import java.util.*;
import java.util.Scanner;

class Main {
    static int n, m;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        int[][] graph = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }


        for(int i = 0; i < m; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            int cost = in.nextInt();
            graph[start][end] = Math.min(graph[start][end], cost);
        }
        floyd(graph, n);

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n ;j++) {
                if(graph[i][j] == Integer.MAX_VALUE) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void floyd(int[][] graph, int n) {

        //경 출 도
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if(i == k) continue;
                    if (graph[j][i] != Integer.MAX_VALUE && graph[i][k] != Integer.MAX_VALUE) {
                        graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                    }
                }
            }
        }
    }
}
