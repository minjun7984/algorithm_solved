import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        //길이가 1인 모든 단어를 포함하도록 사전 초기화
        // 사전에서 현재 입력과 일치하는 가장 긴 문자열 찾는다 w
        //w에 해당하는 사전의 색인번호를 출력 입력에서 w제거
        //입력에서 처리되지 않은 다음 글자 남아있따면 c , w+c에 해당 단어 사전등록
        //단계 2로 돌아감
        Map<String, Integer> dictionary = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        char ch = 'A';
        int num = 27;
        for (int i = 1; i <= 26; i++) {
            dictionary.put(String.valueOf(ch), i);
            ch++;
        }
        int index = 0;
        while (index < msg.length()) {
            String w = "";
            while (index < msg.length()) {
                if (!dictionary.containsKey(w + msg.charAt(index))) {
                    break;
                } else {
                    w += msg.charAt(index);
                }
                index++;
            }
            arr.add(dictionary.get(w));
            if (index < msg.length()) {
                dictionary.put(w + msg.charAt(index), num++);
            }
        }
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}