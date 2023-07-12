import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    static int calcExpiredDay(String termsDay, int type) {
        String[] days = termsDay.split("\\.");
        int year = Integer.parseInt(days[0]);
        int month = Integer.parseInt(days[1]) + type;
        int day = Integer.parseInt(days[2]);

        return countDay(year, month, day);
    }

    static int countDay(int year, int month, int day) {
        return (year * 12 + month) * 28 + day;
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();

        for(String s : terms) {
            String[] termsList = s.split(" ");
            map.put(termsList[0], Integer.parseInt(termsList[1]));
        }

        for(int i = 0; i < privacies.length; i++) {
            String[] privaciesList = privacies[i].split(" ");
            int expiredDay = calcExpiredDay(privaciesList[0], map.get(privaciesList[1]));
            int calcToday = calcExpiredDay(today, 0);
            if(calcToday >= expiredDay) {
                arr.add(i + 1);
            }
        }
        return arr.stream().mapToInt(Integer -> Integer).toArray();
    }
}