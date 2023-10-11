import java.util.*;

class Solution {
    ArrayList<Integer> nums;
    int[] check;
    boolean flag;
    int answer, target, size;

    public void DFS(int L, int number) {
        if (flag) return;
        if (L == size) {
            if (number > target) {
                answer = number;
                flag = true;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    DFS(L + 1, number * 10 + nums.get(i));
                    check[i] = 0;
                }
            }
        }
    }

    public int solution(int n) {
        answer = 0;
        int tmp = n;
        nums = new ArrayList<>();

        while (tmp > 0) {
            int t = tmp % 10;
            nums.add(t);
            tmp /= 10;
        }

        target = n;
        flag = false;
        size = nums.size();
        check = new int[size];
        nums.sort((a, b) -> a - b);

        DFS(0, 0);

        if (flag == false) return -1;
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}