import java.util.*;

class Solution {
    HashSet<String> set;
    boolean[] ch;

    public String[] solution(String s) {
        set = new HashSet<>();
        ch = new boolean[s.length()];

        dfs(s, "");
        String[] answer = new String[set.size()];
        int i = 0;
        for (String tmp : set) {
            answer[i++] = tmp;
        }
        return answer;
    }

    public void dfs(String s, String tmp) {
        //만들어지면 go
        if (tmp.length() == s.length()) {
            StringBuilder sb = new StringBuilder(tmp).reverse();
            if (tmp.equals(sb.toString())) {
                set.add(tmp);
                return;
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (!ch[i]) {
                    ch[i] = true;
                    tmp += s.charAt(i);
                    dfs(s, tmp);
                    ch[i] = false;
                    tmp = tmp.substring(0, tmp.length() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}