package programmers.lv1;
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        //질문  //답한 선택지 정수형 배열
        //survey "RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA"
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            int num = choices[i];
            if (num > 0 && num < 4) {
                char c = survey[i].charAt(0);
                map.put(c, map.getOrDefault(c, 0) + 4 - num);
            } else if (num > 4) {
                char c = survey[i].charAt(1);
                map.put(c, map.getOrDefault(c, 0) + num - 4);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T');
        sb.append(map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F');
        sb.append(map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M');
        sb.append(map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N');
        return sb.toString();
    }
}