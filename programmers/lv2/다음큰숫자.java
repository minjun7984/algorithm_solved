class Solution {
    public static int countBinary(int n) {
        String str = Integer.toBinaryString(n);
        int count = 0;
        char[] ch = str.toCharArray();
        for (char c : ch) {
            if (c == '1')
                count++;
        }
        return count;
    }

    public int solution(int n) {
        int answer = 0;
        int idx = 1;
        int count = countBinary(n);

        while (true) {
            int num = n + idx;
            if (count == countBinary(num)) {
                answer = num;
                break;
            }
            idx++;
        }
        return answer;
    }
}