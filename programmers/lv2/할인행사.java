import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        //원하는 제품과 수량이 할인하는 날짜와 10일 연속 일치할 경우 회원가입
        Map<String, Integer> map = new HashMap<>();
        int answer = 0;

        //원하는 제품과 수량을 map에 담아준다.
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        //한칸씩 밀어주면서 10일 연속 일치여부를 구함
        for (int i = 0; i < discount.length - 9; i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                discountMap.put(discount[i + j], discountMap.getOrDefault(discount[i + j], 0) + 1);
            }
            boolean b = true;
            for (String key : map.keySet()) {
                if (map.get(key) != discountMap.get(key)) {
                    b = false;
                    break;
                }
            }
            answer += b ? 1 : 0;
        }
        return answer;
    }
}