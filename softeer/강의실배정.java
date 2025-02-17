import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int answer = 1;
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            queue.offer(new int[] {a,b});
        }

        int endTime = queue.poll()[1];

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            if(now[0] >= endTime) {
                answer++;
                endTime = now[1];
            }
        }
        System.out.println(answer);
    }
}
