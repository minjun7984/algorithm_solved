import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[5];
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            max = Math.max(map.get(key), max);
        }

        String str = "abcde";
        for (int i = 0; i < str.length(); i++) {
            answer[i] = max - map.getOrDefault(str.charAt(i), 0);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
