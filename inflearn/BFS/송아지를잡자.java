import java.util.*;
class Solution {
    public int[][] visited;

    public int solution(int s, int e){
        int answer = 0;
        visited = new int[2][200001];
        answer = bfs(s, e);
        return answer;
    }

    public int bfs(int s, int e) {
        Queue<Integer> queue = new LinkedList<>();
        visited[0][s] = 1;
        queue.offer(s);
        int L = 0;

        while(!queue.isEmpty()) {
            int len = queue.size();
            L++;
            for(int i = 0; i < len; i++) {
                int tmp = queue.poll();
                for(int nx : new int[] {tmp - 1, tmp + 1, tmp * 2}) {
                    if(nx >= 0 && nx <= 200000 && visited[L % 2][nx] == 0) {
                        visited[L % 2][nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            e += L;
            if(e > 200000) return -1;
            if(visited[L % 2][e] == 1) return L;
        }
        return L;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}