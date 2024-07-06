import java.util.*;

class Solution {
    public int solution(int[][] fruit) {
        int answer = 0;
        boolean[] check = new boolean[fruit.length];

        for (int i = 0; i < fruit.length; i++) {
            if (check[i]) continue; //이미 교환한 학생이면 out
            if (!isUnique(fruit[i])) continue; //유니크하지 않으면 패스
            for (int j = i + 1; j < fruit.length; j++) {
                if (check[j]) continue;
                if (!isUnique(fruit[j])) continue;
                int a = getMin(fruit[i]);
                int b = getMin(fruit[j]);
                if (a != b && fruit[i][b] > 0 && fruit[j][a] > 0) {
                    if (fruit[i][a] + 1 <= fruit[i][b] - 1 && fruit[j][b] + 1 <= fruit[j][a] - 1) {
                        fruit[i][a]++;
                        fruit[i][b]--;
                        fruit[j][a]--;
                        fruit[j][b]++;
                        check[i] = true;
                        check[j] = true;
                        break;
                    }
                }
            }
        }
        for (int[] x : fruit) {
            int tmp = getMin(x);
            answer += x[tmp];
        }
        return answer;
    }

    //최소 과일 값이 유니크한지 판별하는 함수
    public boolean isUnique(int[] f) {
        int cnt = 0;
        int minFruit = getMin(f);
        for (int i = 0; i < 3; i++) {
            if (f[i] == f[minFruit]) cnt++;
        }
        if (cnt >= 2) return false;
        return true;
    }

    //최소값을 가지는 인덱스를 가져오는 함수
    public int getMin(int[] f) {
        int min = 0;
        for (int i = 1; i < 3; i++) {
            if (f[min] > f[i]) {
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}