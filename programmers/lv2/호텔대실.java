import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        //최소한의 객실만 사용해 손님을 받는다
        //퇴실 시간 기준으로 10분간 청소하고 다음 손님 이용
        //코니에게 필요한 최소 객실의 수
        int answer = 0;
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0])); //입실 시간 기준으로 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]); //배정 받은 방들 종료시간 기준 오름차순

        for(String[] book: book_time) {
            String[] start = book[0].split(":");
            String[] end = book[1].split(":");
            int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 10;
            //배정받은 방이 없다면 pq에 해당 시간 넣고 방배정!
            if(pq.isEmpty()) {
                answer++;
                pq.offer(new int[]{startTime, endTime});
                continue;
            }

            //pq안에 있는 방들과 비교한다.
            int[] room = pq.poll();
            int pqStart = room[0]; //시작시간
            int pqEnd = room[1]; //끝

            //시작시간이 방의 퇴실시간 보다 후거나 같으면 그 방에 배정
            if(startTime >= pqEnd) {
                pq.offer(new int[]{startTime, endTime});
            } else {
                answer++;
                pq.offer(new int[]{startTime, endTime});
                pq.offer(room);
            }
        }
        return answer;
    }
}