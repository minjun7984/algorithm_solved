import java.util.*;

class Solution {
    String[] words;
    static int count = 0;
    static int answer = 0;

    public int solution(String word) {
        String alpha = "AEIOU";
        words = alpha.split("");

        dfs("", word);
        return answer;
    }

    public void dfs(String tmp, String word) {
        if (tmp.equals(word)) {
            answer = count;
            return;
        }
        if (tmp.length() == 5) return;

        for (int i = 0; i < 5; i++) {
            tmp += words[i];
            count++;
            dfs(tmp, word);
            tmp = tmp.substring(0, tmp.length() - 1);
        }
    }
}