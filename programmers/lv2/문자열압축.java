class Solution {
    public int solution(String s) {
        int answer = s.length();
        int count = 1;
        //문자열 길이의 절반만 확인하면 된다!
        int len = s.length() / 2;

        for (int i = 1; i <= len; i++) {
            StringBuilder sb = new StringBuilder();
            String baseWord = s.substring(0, i); //비교할 값

            for (int j = i; j <= s.length(); j += i) {
                int endIdx = i + j;
                if (i + j > s.length()) {
                    endIdx = s.length();
                }
                String compareWord = s.substring(j, endIdx);

                if (baseWord.equals(compareWord)) {
                    count++;
                } else {
                    if (count >= 2) {
                        sb.append(count);
                    }
                    sb.append(baseWord);
                    baseWord = compareWord;
                    count = 1;
                }
            }
            sb.append(baseWord);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}
