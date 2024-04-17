class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = s.length(); i > 0; i--) {
            for (int j = 0; j + i <= s.length(); j++) {
                if (isPalindrome(s, j, j + i - 1)) return i;
            }
        }
        return answer;
    }

    boolean isPalindrome(String tmp, int start, int end) {
        while (start <= end) {
            if (tmp.charAt(start++) != tmp.charAt(end--)) return false;
        }
        return true;
    }
}