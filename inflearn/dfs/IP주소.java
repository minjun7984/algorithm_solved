import java.util.*;

class Solution {
    ArrayList<String> arr;
    LinkedList<String> tmp;

    public void DFS(int start, String s) {
        if (tmp.size() == 4 && start == s.length()) {
            String t = "";
            for (String x : tmp) {
                t += x + ".";
            }
            arr.add(t);
        } else {
            for (int i = start; i < s.length(); i++) {
                if (s.charAt(start) == '0' && i > start) return;
                String num = s.substring(start, i + 1);
                if (Integer.parseInt(num) > 255) return;
                tmp.add(num);
                DFS(i + 1, s);
                tmp.pollLast();
            }
        }
    }

    public String[] solution(String s) {
        arr = new ArrayList<>(); //완성 IP 담자
        tmp = new LinkedList<>(); //IP 각 자리가 담길 리스트
        DFS(0, s);
        String[] answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}