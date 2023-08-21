class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        int num =0;
        int len = t * m;

        while(sb.length() < len) {
            String tmp = Integer.toString(num, n).toUpperCase();
            sb.append(tmp);
            num++;
        }

        String str = sb.substring(0, len);
        for(int i = p-1; i < str.length(); i+= m) {
            char c = str.charAt(i);
            answer.append(c);
        }
        return answer.toString();
    }
}