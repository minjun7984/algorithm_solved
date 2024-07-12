import java.util.*;

class Solution {
    Map<String, int[]> map = new HashMap<>();

    public int[] solution(int[] fees, String[] records) {
        TreeSet<String> set = new TreeSet<>();

        for (int i = 0; i < records.length; i++) {
            String[] tmp = records[i].split(" ");
            set.add(tmp[1]);

            if (tmp[2].equals("OUT")) {
                map.get(tmp[1])[1] += convertHourToMinutes(tmp[0]) - map.get(tmp[1])[0];
                map.get(tmp[1])[2] = 1;
                continue;
            }

            int cost = 0;
            if (map.containsKey(tmp[1])) cost = map.get(tmp[1])[1];
            map.put(tmp[1], new int[]{convertHourToMinutes(tmp[0]), cost, 0});
        }

        int[] answer = new int[set.size()];
        int index = 0;
        for (String x : set) {
            if (map.get(x)[2] == 0) {
                map.get(x)[1] += convertHourToMinutes("23:59") - map.get(x)[0];
            }
            answer[index++] = calculatePrice(fees, x, map.get(x)[1]);
        }
        return answer;
    }

    private int convertHourToMinutes(String s) {
        String[] tmp = s.split(":");
        int hourToMinute = Integer.parseInt(tmp[0]) * 60;
        return hourToMinute + Integer.parseInt(tmp[1]);
    }

    private int calculatePrice(int[] fees, String carNumber, int time) {
        System.out.println(time);
        if (time <= fees[0]) return fees[1];

        int cal = (int) Math.ceil((double) (time - fees[0]) / fees[2]);

        return fees[1] + (cal * fees[3]);
    }
}