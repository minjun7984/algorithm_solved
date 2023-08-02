import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Set<String> set = new HashSet<>();

        while (str1.length() >= 2) {
            String s = str1.substring(0, 2);
            str1 = str1.substring(1, str1.length());
            if (Character.isAlphabetic(s.charAt(0)) && Character.isAlphabetic(s.charAt(1))) {
                map1.put(s, map1.getOrDefault(s, 0) + 1);
                set.add(s);
            }
        }

        while (str2.length() >= 2) {
            String s = str2.substring(0, 2);
            str2 = str2.substring(1, str2.length());
            if (Character.isAlphabetic(s.charAt(0)) && Character.isAlphabetic(s.charAt(1))) {
                map2.put(s, map2.getOrDefault(s, 0) + 1);
                set.add(s);
            }
        }

        //합집합 구하기
        int total1 = 0; //합집합 개수의 합을 담을 변수
        int total2 = 0;
        for (String s : set) {
            total1 += Math.max(map1.getOrDefault(s, 0), map2.getOrDefault(s, 0));
            if (map1.getOrDefault(s, 0) != 0 && map2.getOrDefault(s, 0) != 0) {
                total2 += Math.min(map1.get(s), map2.get(s));
            }
        }

        if (total1 == 0 && total2 == 0) {
            return 65536;
        }

        answer = 65536 * total2 / total1;
        return answer;
    }
}