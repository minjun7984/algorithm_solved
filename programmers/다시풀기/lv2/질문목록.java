import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        //뒤에 잇는 기능이 앞에있는 기능보다 먼저 개발될 수 있고 앞에있는 기능 배포될 때 같이 배포된다.
        Queue<Integer> endQueue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int dis = 100 - progresses[i];
            int remain = 0;
            if (dis % speeds[i] == 0) {
                remain = dis / speeds[i];
            } else {
                remain = dis / speeds[i] + 1;
            }
            endQueue.offer(remain);
        }

        while (!endQueue.isEmpty()) {
            int count = 0;
            int first = endQueue.poll();
            count++;

            while (true) {
                if (endQueue.isEmpty()) break;
                if (endQueue.peek() > first) break;
                endQueue.poll();
                count++;
            }
            list.add(count);
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}