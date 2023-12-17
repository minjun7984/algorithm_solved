import java.util.*;
class Solution {
    int n, answer;
    int[] check;
    public void dfs(int L, int s, int[][] cans) {
        if(L == n/2) {
            ArrayList<Integer> odd = new ArrayList<>();
            ArrayList<Integer> even = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if(check[i] == 1) {
                    odd.add(i);
                } else {
                    even.add(i);
                }
            }
            int oddSum = 0;
            int evenSum = 0;
            for(int i = 0; i < L; i++) {
                oddSum += cans[odd.get(i)][0];
                evenSum += cans[even.get(i)][1];
            }
            answer = Math.min(answer, Math.abs(oddSum - evenSum));
        } else {
            for(int i = s; i < n; i++) {
                check[i] = 1;
                dfs(L + 1, i + 1, cans);
                check[i] = 0;
            }
        }
    }
    public int solution(int[][] cans){
        answer = Integer.MAX_VALUE;
        n = cans.length;
        check = new int[n];
        dfs(0, 0 , cans);
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}
