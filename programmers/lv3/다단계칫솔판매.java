import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        //칫솔을 판매하면 이익이 피라미드 조직을 타고 조금씩 분배되는 형태의 판매망 amount * 100;
        int[] answer = {};
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> moneyMap = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            if (!map.containsKey(enroll[i])) {
                map.put(enroll[i], referral[i]);
                moneyMap.put(enroll[i], 0);
            }
        }

        for (int i = 0; i < seller.length; i++) {
            String sellerHuman = seller[i]; //판사람
            int money = amount[i] * 100; // 요만큼 팔았쥐~
            int divideMoney = money / 10;
            int sendMoney = money - divideMoney; //추천인에게 돈을 바친다

            if (map.containsKey(sellerHuman)) { //내가먹을 돈 저장하자
                moneyMap.put(sellerHuman, moneyMap.get(sellerHuman) + sendMoney);
                //이제 추천인에게 돈을 바칠시간...
                while (!map.get(sellerHuman).equals("-")) {
                    String recomendHuman = map.get(sellerHuman);
                    if (money == 0) break;
                    else money /= 10;
                    divideMoney = money / 10;
                    sendMoney = money - divideMoney;
                    moneyMap.put(recomendHuman, moneyMap.get(recomendHuman) + sendMoney);
                }
            }
        }
        int idx = 0;
        answer = new int[enroll.length];
        for (String en : enroll) {
            answer[idx++] = moneyMap.get(en);
        }
        return answer;
    }
}