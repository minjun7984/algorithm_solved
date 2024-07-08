import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for(String[] cloth : clothes) {
            if(map.containsKey(cloth[1])) {
                map.put(cloth[1], map.get(cloth[1]) + 1);
                continue;
            }
            map.put(cloth[1], 1);
        }

        for(String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }
        return answer - 1;
    }
}