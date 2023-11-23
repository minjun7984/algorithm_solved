import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        //불량 이용자를 신고처리하고 메일로 발송
        //유저는 한번에 한명 신고 가능 동일한 유저의 반복신고는 1회로 처리됨.
        //k번 이상 신고된 유저는 이용 정지 해당 유저 신고한 유저에게 정지 사실 발송
        //이용자 아이디,  문자열 배열, 정지 기준 k
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> idxMap = new HashMap<>();

        for(int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            map.put(name, new HashSet<>());
            idxMap.put(name, i);
        }

        for(String s : report) {
            String[] user = s.split(" ");
            String fromUser = user[0];
            String toUser = user[1];
            map.get(toUser).add(fromUser);
        }

        for(int i = 0; i < id_list.length; i++) {
            HashSet<String> send = map.get(id_list[i]);
            if(send.size() >= k) {
                for(String name : send) {
                    answer[idxMap.get(name)]++;
                }
            }
        }
        return answer;
    }
}
        