import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 실행 대기 큐를 꺼낸다 -> 우선순위가 높은 프로세스가 있으면 다시 큐에 넣는다.
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int answer = 0;
        for(int i : priorities) {
            queue.offer(i);
        }

        while(!queue.isEmpty()) {
            for(int i = 0; i< priorities.length; i++){
                if(priorities[i] == queue.peek()) {
                    if(i == location) {
                        answer++;
                        return answer;
                    }
                    queue.poll();
                    answer++;
                }
            }
        }
        return answer;
    }
}