import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String[] s = record[i].split(" ");
            if (s[0].charAt(0) == 'L') continue;
            map.put(s[1], s[2]);
        }

        for (int i = 0; i < record.length; i++) {
            String[] s = record[i].split(" ");
            if (s[0].charAt(0) == 'E') {
                arr.add(map.get(s[1]) + "님이 들어왔습니다.");
            }

            if (s[0].charAt(0) == 'L') {
                arr.add(map.get(s[1]) + "님이 나갔습니다.");
            }
        }
        return arr.toArray(new String[arr.size()]);
    }
}