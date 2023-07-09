class Solution {
    public String solution(String s) {
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(String x : ss) {
            for(int i = 0; i < x.length(); i++) {
                if(i == 0 && Character.isAlphabetic(x.charAt(i))) {
                    sb.append(Character.toUpperCase(x.charAt(i)));
                }
                else if(i != 0 && Character.isUpperCase(x.charAt(i))) {
                    sb.append(Character.toLowerCase(x.charAt(i)));
                }
                else sb.append(x.charAt(i));
            }
            sb.append(" ");
        }
        String answer = sb.toString();
        // 입력 받은 문자열의 맨 마지막이 " " 라면 바로 answer 반환
        if(s.substring(s.length()-1, s.length()).equals(" ")){
            return answer;
        }
        // 맨 마지막 " " 제거하고 answer 반환
        return answer.substring(0, answer.length()-1);
    }
}