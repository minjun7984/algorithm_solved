import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int[] visited = new int[n];

        for(int i = 0; i < visited.length; i++) {
            visited[i] = in.nextInt();
        }

        int sum = 0;
        for(int i = 0; i < x; i++) {
            sum += visited[i];
        }

        int answer = sum;
        int maxCount = 1;
        for(int i = x; i < n; i++) {
            sum += visited[i] - visited[i - x];
            if(sum == answer) maxCount++;
            if(answer < sum) {
                answer = sum;
                maxCount = 1;
            }
        }
        if(answer == 0) {
            System.out.println("SAD");
            System.exit(0);
        }
        System.out.println(answer);
        System.out.println(maxCount);
    }
}

