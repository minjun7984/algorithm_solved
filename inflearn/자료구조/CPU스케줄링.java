import java.util.*;

class Solution {
    public int[] solution(int[][] tasks) {
        int[] answer = new int[tasks.length];
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < tasks.length; i++) {
            queue.offer(new int[]{tasks[i][0], tasks[i][1], i});
        }
        queue.sort((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ?
                a[1] - b[1] : a[0] - b[0]);

        int idx = 0;
        int endTime = 0;
        //큐가 모두 비어있으면 정지
        while (!queue.isEmpty() || !pq.isEmpty()) {
            if (pq.isEmpty()) endTime = Math.max(endTime, queue.peek()[0]);
            //큐가 비어있지않고 진행할 시작시간이 endTime보다 작다면
            while (!queue.isEmpty() && queue.peek()[0] <= endTime) {
                int[] x = queue.poll();
                pq.offer(new int[]{x[1], x[2]});
            }
            int[] tmp = pq.poll();
            endTime += tmp[0];
            answer[idx++] = tmp[1];
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}