import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Deque<long[]> queue = new LinkedList<>();

        int startIdx = 1;
        for (int i = 0; i < n; i++) {
            int size = in.nextInt();
            queue.offer(new long[]{size, startIdx++});
        }
        //1개남으면 그것이 최종 미생물이 된다.
        while (queue.size() > 1) {
            Deque<long[]> deQueue = new LinkedList<>();
            //큐가 빌 때까지 가동
            while (!queue.isEmpty()) {
                long[] now = queue.poll();
                long nowSize = now[0];
                //데큐 꺼낸 값이 현재보다 작다면 합쳐져야한다. 왼쪽에 헤당하는거겟죠
                if (!deQueue.isEmpty() && deQueue.peekLast()[0] <= nowSize) {
                    long[] pre = deQueue.pollLast();
                    nowSize += pre[0];
                }
                //오른쪽 비교해야함 꺼낸 것이 현재 사이즈보다 작거나 같으면 합쳐줘 주의할 점은 합치기 전 값을 기준으로 비교
                if (!queue.isEmpty() && queue.peek()[0] <= now[0]) {
                    long[] next = queue.poll();
                    nowSize += next[0];
                }
                deQueue.offer(new long[]{nowSize, now[1]});
            }
            queue = deQueue;
        }
        long[] answerQueue = queue.poll();
        System.out.println(answerQueue[0]);
        System.out.print(answerQueue[1]);
    }
}
