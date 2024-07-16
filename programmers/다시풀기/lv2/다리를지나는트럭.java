import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        //최대 다리길이만큼 올라갈 수 있음
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{truck_weights[0], 1});
        int totalWeight = truck_weights[0];
        int index = 1;
        int time = 1;

        while (!queue.isEmpty()) {
            if (queue.peek()[1] == bridge_length) {
                totalWeight -= queue.poll()[0];
            }
            for (int i = 0; i < queue.size(); i++) {
                queue.get(i)[1]++;
            }

            if (index < truck_weights.length && queue.size() < bridge_length && totalWeight + truck_weights[index] <= weight) {
                queue.offer(new int[]{truck_weights[index], 1});
                totalWeight += truck_weights[index++];
            }
            time++;
        }
        return time;
    }
}