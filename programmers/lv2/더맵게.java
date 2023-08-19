import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] scoville, int K) {
        //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        PriorityQueue<Integer> pq = Arrays.stream(scoville).boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));

        int count = 0;
        int firstScoville = pq.peek();
        while (K > firstScoville && pq.size() > 1) {
            count++;
            int a = pq.poll();
            int b = pq.poll();
            int tmp = a + (b * 2);
            pq.add(tmp);
            firstScoville = pq.peek();
        }

        if (K > firstScoville) {
            return -1;
        }
        return count;
    }
}
