import java.util.*;
import java.util.Scanner;

class Main {
    static int v, e;
    static int answer = Integer.MAX_VALUE;
    static int[][] costs;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        v = in.nextInt();
        e = in.nextInt();
        costs = new int[v + 1][v + 1];
        for (int i = 0; i <= v; i++) {
            for (int j = 0; j <= v; j++) {
                if (i == j) continue;
                else costs[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < e; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            int cost = in.nextInt();
            costs[start][end] = cost;
        }
        Floyd();
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i == j) continue;
                if (costs[i][j] != Integer.MAX_VALUE && Integer.MAX_VALUE != costs[j][i]) {
                    answer = Math.min(answer, costs[i][j] + costs[j][i]);
                }
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    //경 출 도
    static void Floyd() {
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                for (int k = 1; k <= v; k++) {
                    if (i == k) continue;
                    if (costs[j][i] != Integer.MAX_VALUE && costs[i][k] != Integer.MAX_VALUE) {
                        costs[j][k] = Math.min(costs[j][k], costs[j][i] + costs[i][k]);
                    }
                }
            }
        }
    }
}
