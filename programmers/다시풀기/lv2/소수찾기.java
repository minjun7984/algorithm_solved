import java.util.*;

class Solution {
    Set<Integer> set;
    int[] visited;
    char[] num;

    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        visited = new int[numbers.length()];
        num = new char[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
            num[i] = numbers.charAt(i);
        }

        dfs("");
        return set.size();
    }

    public void dfs(String s) {
        if (!s.equals("") && isPrime(Integer.parseInt(s))) {
            set.add(Integer.parseInt(s));
        }

        for (int i = 0; i < num.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                dfs(s + num[i]);
                visited[i] = 0;
            }
        }
    }

    public boolean isPrime(int num) {
        int count = 0;
        boolean flag = true;
        if (num == 1 || num == 0) flag = false;

        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) count++;
            if (count >= 1) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}