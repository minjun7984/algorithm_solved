class Solution {
    public String solution(String new_id) {
        //1단계 대문자를 소문자로 치환
        String answer = new_id.toLowerCase();

        //2단계 소문자, 숫자, 빼기 밑줄 마침표 이외 문자 제거
        answer = answer.replaceAll("[^-_.a-z0-9]","");

        //3단계 new_id에서 마침표 .가 2번 이상 연속된 부분을 하나의 마침표로 치환한다.
        while(answer.contains("..")) {
            answer = answer.replace("..", ".");
        }

        //4단계 마침표가 처음이나 끝에 위치하면 제거
        if(answer.charAt(0) == '.') {
            answer = answer.substring(1, answer.length());
        }
        else if(answer.charAt(answer.length()-1) == '.') {
            answer = answer.substring(0, answer.length()-1);
        }

        //5단계 빈문자열이면 a를 대입한다!
        if(answer.equals("")) {
            answer = "a";
        }

        //6단계 길이가 16이상이면 15개문자를 제외한 나머지 문자를 모두 제거한다. 제거후 마침표가 끝이면 마침표도 제거
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }
        if(answer.charAt(answer.length()-1) == '.') {
            answer = answer.substring(0, answer.length() -1);
        }

        //7단계 2자 이하라면 마지막 문자를 길이가 3이 될때까지 반복해 끝에 붙인다.
        if(answer.length() <= 2) {
            while(answer.length() < 3) {
                answer += answer.charAt(answer.length()-1);
            }
        }
        return answer;
    }
}