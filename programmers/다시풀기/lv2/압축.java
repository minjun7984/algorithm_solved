import java.util.*;
class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        char alpha = 'A';
        int num = 27;
        for(int i = 1; i <= 26; i++) {
            map.put(String.valueOf(alpha++), i);
        }
        int index = 0;
        while(index < msg.length()) {
            String tmp = "";
            while(index < msg.length()) {
                if(!map.containsKey(tmp + msg.charAt(index))) {
                    break;
                }
                else {
                    tmp += msg.charAt(index);
                }
                index++;
            }
            list.add(map.get(tmp));
            if(index < msg.length()) {
                map.put(tmp + msg.charAt(index), num++);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);

        return answer;
    }
}