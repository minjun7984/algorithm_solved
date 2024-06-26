import java.util.*;

class Solution {
    public int solution(int[] pool, int a, int b, int home) {
        int answer = 0;
        int[][] map = new int[2][10001];
        for (int i = 0; i < pool.length; i++) {
            map[0][pool[i]] = 1;
            map[1][pool[i]] = 1;

        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); //0 앞 1 뒤점
        map[0][0] = 1;
        map[1][0] = 1;
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] now = queue.poll();
                int dir = now[1];

                if (now[0] == home) return L;
                int nx = now[0] + a;

                if (nx <= 100001 && map[0][nx] == 0) {
                    map[0][nx] = 1;
                    queue.offer(new int[]{nx, 0});
                }

                nx = now[0] - b;
                if (nx >= 0 && map[1][nx] == 0 && dir == 0) {
                    map[1][nx] = 1;
                    queue.offer(new int[]{nx, 1});
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}