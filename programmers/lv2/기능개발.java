import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        //배포되어야하는 순서 //개발속도 각 배포마다 몇개의 기능이 배포되는가
        Queue<Integer> queue = new LinkedList<>();

        //남은 일수 계산
        for(int i = 0; i < progresses.length; i++) {
            int rest = 100 - progresses[i];
            if(rest % speeds[i] == 0) {
                queue.offer(rest / speeds[i]);
            } else {
                queue.offer(rest/ speeds[i] + 1);
            }
        }
        List<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()) {
            int days = queue.poll();
            int count = 1;
            while(!queue.isEmpty() && queue.peek() <= days) {
                queue.poll();
                count++;
            }
            list.add(count);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}