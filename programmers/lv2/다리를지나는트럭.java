import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;

        LinkedList<int[]> queue = new LinkedList<>();
        int truckIndex = 0;
        int bridgeTruckWeight = truck_weights[0];

        queue.offer(new int[]{truck_weights[0], 1});

        while(!queue.isEmpty()) {
            //큐에 들어와있던 시간이 다리에 길이와 같다면 다리를 다 지난 것!
            if (queue.peek()[1] == bridge_length) {
                int truckWeight = queue.poll()[0];
                bridgeTruckWeight -= truckWeight;
            }

            //큐안에 차들이 들어와있던 시간 증가시켜준다
            for (int i = 0 ; i < queue.size(); i++) {
                queue.get(i)[1]++;
            }

            //다리를 건너는 중인 트럭과 다음트럭 무게 비교해 다리에 들어올 수 있는지
            if (truckIndex +1 < truck_weights.length && bridgeTruckWeight + truck_weights[truckIndex+1] <= weight
                    && queue.size() <= bridge_length) {
                truckIndex++;
                queue.offer(new int[]{truck_weights[truckIndex], 1});
                bridgeTruckWeight += truck_weights[truckIndex];
            }
            answer++;
        }
        return answer;
    }
}