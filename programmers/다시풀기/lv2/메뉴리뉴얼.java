import java.util.*;

class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<String> arr = new ArrayList<>();

    public String[] solution(String[] orders, int[] course) {
        //오름차순으로 만들어준다 xa ax 이런경우 방지
        for (int i = 0; i < orders.length; i++) {
            char[] c = orders[i].toCharArray();
            Arrays.sort(c);
            orders[i] = String.valueOf(c);
        }

        for (int courseLength : course) {
            for (String order : orders) {
                dfs(courseLength, order, "");
            }
            int max = 0;
            if (!map.isEmpty()) {
                for (int i = 0; i < map.size(); i++) {
                    for (String key : map.keySet()) {
                        max = Math.max(map.get(key), max);
                    }
                }
            }
            if (max >= 2) {
                for (String key : map.keySet()) {
                    if (map.get(key) == max) {
                        arr.add(key);
                    }
                }
            }
            map.clear();
        }
        Collections.sort(arr);
        String[] answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }

    public void dfs(int courseLen, String order, String s) {
        //길이가 같다면
        if (s.length() == courseLen) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            return;
        } else {
            for (int i = 0; i < order.length(); i++) {
                dfs(courseLen, order.substring(i + 1), s + order.charAt(i));
            }
        }
    }
}