import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

        for (String[] s : book_time) {
            int startTime = convertTime(s[0]);
            int endTime = convertTime(s[1]);

            if (pq.isEmpty()) {
                answer++;
                pq.offer(endTime + 10);
                continue;
            }

            int exitTime = pq.peek();
            if (startTime >= exitTime) {
                pq.poll();
                pq.offer(endTime + 10);
            } else {
                answer++;
                pq.offer(endTime + 10);
            }
        }
        return answer;
    }

    private int convertTime(String s) {
        String[] tmp = s.split(":");
        int hour = Integer.parseInt(tmp[0]) * 60;
        int minute = Integer.parseInt(tmp[1]);
        return hour + minute;
    }
}