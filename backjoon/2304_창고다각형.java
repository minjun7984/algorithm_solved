import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int answer = 0, left = 0, right = 0;
        int[] arr = new int[1001];

        int maxHeight = 0;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            int l = in.nextInt();
            int h = in.nextInt();
            arr[l] = h;
            if (l < left) left = l;  // 가장 왼쪽 기둥 위치
            if (l > right) right = l;
            if (h > maxHeight) {
                maxHeight = h;
                maxIndex = l;
            }
        }

        int leftMaxHeight = 0;
        for (int i = left; i <= maxIndex; i++) {
            if (arr[i] > leftMaxHeight) {
                leftMaxHeight = arr[i];
            }
            answer += leftMaxHeight;
        }

        int rightMaxHeight = 0;
        for (int i = right; i >= maxIndex; i--) {
            if (arr[i] > rightMaxHeight) {
                rightMaxHeight = arr[i];
            }
            answer += rightMaxHeight;
        }
        System.out.println(answer - maxHeight);
    }
}
