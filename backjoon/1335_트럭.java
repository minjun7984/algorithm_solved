import java.util.*;

class Main {
    static int n;
    static int w;
    static int l;
    static int[] trucks;
    static Queue<Integer> bridge = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        w = in.nextInt();
        l = in.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(in.nextInt());
        }

        for (int i = 0; i < w; i++) {
            bridge.offer(0);
        }

        int answer = 0;
        int weight = 0;

        while (!bridge.isEmpty()) {
            answer++;
            weight -= bridge.poll();
            if (queue.isEmpty()) {
                continue;
            }
            //다리 올라가기 가능하면?
            if (weight + queue.peek() <= l) {
                int truck = queue.poll();
                weight += truck;
                bridge.offer(truck);
            } else {
                bridge.offer(0);
            }
        }
        System.out.println(answer);
    }
}
