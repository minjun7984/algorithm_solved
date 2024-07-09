import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        Map<String, Integer> word1 = new HashMap<>();
        Map<String, Integer> word2 = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        while (str1.length() >= 2) {
            String s = str1.substring(0, 2);
            if (Character.isAlphabetic(s.charAt(0)) && Character.isAlphabetic(s.charAt(1))) {
                word1.put(s, word1.getOrDefault(s, 0) + 1);
                set.add(s);
            }
            str1 = str1.substring(1);
        }

        while (str2.length() >= 2) {
            String s = str2.substring(0, 2);
            if (Character.isAlphabetic(s.charAt(0)) && Character.isAlphabetic(s.charAt(1))) {
                word2.put(s, word2.getOrDefault(s, 0) + 1);
                set.add(s);
            }
            str2 = str2.substring(1);
        }

        int total1 = 0; // 교집합 수
        int total2 = 0; // 합집합 수
        for (String s : set) {
            int word1Count = word1.getOrDefault(s, 0);
            int word2Count = word2.getOrDefault(s, 0);
            total1 += Math.min(word1Count, word2Count);
            total2 += Math.max(word1Count, word2Count);
        }

        if (total1 == 0 && total2 == 0) return 65536;
        answer = 65536 * total1 / total2;

        return answer;
    }
}