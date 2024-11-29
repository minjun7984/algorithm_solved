import java.util.*;

class Main {
    static int n, k;
    static Queue<Integer> bagQueue = new PriorityQueue<>((a, b) -> a - b);
    static Queue<int[]> jewelQueue = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]
    );

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        k = in.nextInt();
        long answer = 0;
        for (int i = 0; i < n; i++) {
            int m = in.nextInt(); //무게
            int v = in.nextInt(); // 가격
            jewelQueue.add(new int[]{m, v});
        }

        for (int i = 0; i < k; i++) {
            bagQueue.add(in.nextInt());
        }

        Queue<Integer> answerQueue = new PriorityQueue<>((a, b) -> b - a);
        int idx = 0;
        while (!bagQueue.isEmpty()) {
            int now = bagQueue.poll(); //백에 담을 수 잇는 무게
            while (idx < n && jewelQueue.peek()[0] <= now) {
                answerQueue.offer(jewelQueue.poll()[1]);
                idx++;

            }
            if (!answerQueue.isEmpty()) {
                answer += answerQueue.poll();
            }

        }
        System.out.println(answer);
    }
}
