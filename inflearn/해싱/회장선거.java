import java.util.*;

class Solution {
    public String solution(String[] votes, int k) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        Map<String, Integer> thankStudent = new HashMap<>();
        ArrayList<String> answerList = new ArrayList<>();

        for (int i = 0; i < votes.length; i++) {
            String[] s = votes[i].split(" ");
            map.put(s[1], map.getOrDefault(s[1], new ArrayList<String>()));
            map.get(s[1]).add(s[0]);
        }
        //선거 나설 수 있는 사람
        int max = 0;
        for (String key : map.keySet()) {
            ArrayList<String> tmp = map.get(key);
            if (tmp.size() >= k) {
                for (int i = 0; i < tmp.size(); i++) {
                    thankStudent.put(tmp.get(i), thankStudent.getOrDefault(tmp.get(i), 0) + 1);
                    max = Math.max(max, thankStudent.get(tmp.get(i)));
                }
            }
        }

        for (String key : thankStudent.keySet()) {
            if (thankStudent.get(key) == max) answerList.add(key);
        }

        Collections.sort(answerList);
        return answerList.get(0);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}