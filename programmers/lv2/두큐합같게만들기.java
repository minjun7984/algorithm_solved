import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long target = 0;
        long q1Sum = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i = 0; i < queue1.length; i++) {
            target += queue1[i] + queue2[i];
            q1Sum += queue1[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        if(target % 2 != 0) return -1;
        target /= 2;

        while(true) {
            if(answer > (queue1.length + queue2.length) * 2) return -1;
            if(q1Sum == target) break;
            else if(q1Sum > target) {
                int tmp = q1.poll();
                q1Sum -= tmp;
                q2.offer(tmp);
            } else {
                int tmp = q2.poll();
                q1Sum += tmp;
                q1.offer(tmp);
            }
            answer++;
        }
        return answer;
    }
}