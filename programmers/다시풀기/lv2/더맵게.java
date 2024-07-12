import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {

        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            queue.offer(scoville[i]);
        }

        while (queue.size() > 1) {
            int firstValue = queue.poll();
            if (firstValue >= K) continue;

            int secondValue = queue.poll();
            int mix = firstValue + (secondValue * 2);
            queue.offer(mix);
            answer++;
        }
        if (queue.poll() < K) return -1;
        return answer;
    }
}