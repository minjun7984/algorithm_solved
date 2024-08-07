class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = toBinary(n, k); //n을 k진법으로 바꾸자 바꾸기 완료
        String[] num = s.split("0");
        for (String ss : num) {
            if (ss.equals("")) continue;
            if (isPrime(Long.parseLong(ss))) answer++;
        }
        return answer;
    }

    private static String toBinary(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }

    private static boolean isPrime(long num) {
        if (num == 1) return false;
        for (int i = 2; i < (int) Math.sqrt(num) + 1; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}