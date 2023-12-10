import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    static int[] check;
    static String[] str;
    static HashSet<Integer> hashSet = new HashSet<>();

    public void dfs(String num, int index) {
        int number;
        if(!num.equals("")) {
            number = Integer.parseInt(num);
            if(isPrime(number)) hashSet.add(number);
        }
        if(index == check.length) return;

        for(int i = 0; i < check.length; i++) {
            if(check[i] == 1) continue;
            check[i] = 1;
            dfs(num + str[i], index + 1);
            check[i] = 0;
        }
    }

    //소수를 구해보자
    public boolean isPrime(int num) {
        if(num < 2) return false;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    public int solution(String numbers) {
        str = numbers.split("");
        check = new int[str.length];

        dfs("", 0);

        return hashSet.size();
    }
}