import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        int[][] total = new int[friends.length][friends.length];
        int[] send = new int[friends.length];
        int[] receive = new int[friends.length];
        HashMap<String, Integer> map = new HashMap<>();

        //각 인덱스 저장
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }

        for (int i = 0; i < gifts.length; i++) {
            String[] s = gifts[i].split(" ");
            int to = map.get(s[0]); //보낸이
            int from = map.get(s[1]); //받은이

            total[to][from]++;
            send[to]++;
            receive[from]++;
        }

        for (int i = 0; i < friends.length; i++) {
            int count = 0;
            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;

                int personA = total[i][j];
                int personB = total[j][i];

                if (personA != 0 || personB != 0) {
                    if (personA > personB) count++;
                }

                if (personA == 0 && personB == 0 || personA == personB) {
                    int personValueA = send[i] - receive[i];
                    int personValueB = send[j] - receive[j];
                    if (personValueA > personValueB) count++;
                }
            }
            answer = Math.max(count, answer);
        }
        return answer;
    }
}