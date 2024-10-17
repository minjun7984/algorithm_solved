import java.util.*;

public class Main {
    static int[] heights;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int answer = 0;
        heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int count = viewCount(i);
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }

    static int viewCount(int start) {
        double tmp = 0;
        int count = 0;


        for (int i = start - 1; i >= 0; i--) {
            double gradient = (double) (heights[start] - heights[i]) / (start - i);
            if (i == start - 1 || tmp > gradient) {
                tmp = gradient;
                count++;
            }
        }

        for (int i = start + 1; i < heights.length; i++) {
            double gradient = (double) (heights[i] - heights[start]) / (i - start);
            if (i == start + 1 || tmp < gradient) {
                tmp = gradient;
                count++;
            }
        }
        return count;
    }
}
