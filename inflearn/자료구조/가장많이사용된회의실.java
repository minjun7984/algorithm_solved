import java.util.*;

class Solution {
    //시작 시간이 더 빠른 회의를 회의실에 배정한다.
    //회의실이 여러개일 경우 가장 번호가 낮은 회의실에 회의 배정
    //사용가능이 없는 경우 다음 순서 회의는 가장 많은 회의를 진행한 회의실 번호를 반환한다.
    public int solution(int n, int[][] meetings) {
        int answer = 0;
        int[] count = new int[n];
        TreeSet<Integer> roomSet = new TreeSet<>();
        PriorityQueue<int[]> endQueue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]); //0 끝나는 시간 1 룸 번호
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        //방 생성
        for (int i = 0; i < n; i++) {
            roomSet.add(i);
        }

        for (int[] meet : meetings) {
            //끝난 작업들 방을 다 반환한다.
            while (!endQueue.isEmpty() && endQueue.peek()[0] <= meet[0]) {
                roomSet.add(endQueue.poll()[1]);
            }
            //방이 남아있는 경우
            if (!roomSet.isEmpty()) {
                int room = roomSet.pollFirst();
                count[room]++;
                endQueue.offer(new int[]{meet[1], room});
            } else {
                int[] end = endQueue.poll();
                count[end[1]]++;
                endQueue.offer(new int[]{end[0] + meet[1] - meet[0], end[1]});
            }
        }
        int maxRoomIdx = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[maxRoomIdx] < count[i]) maxRoomIdx = i;
        }
        return maxRoomIdx;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}