import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        //가장 최근을 교체 hit 1 miss 5
        int answer = 0;
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase();
        }
        Queue<String> queue = new LinkedList<>();
        if(cacheSize == 0) return answer = 5 * cities.length;
        for (int i = 0; i < cities.length; i++) {
            if (queue.isEmpty()) {
                queue.offer(cities[i]);
                answer += 5;
                continue;
            }
            if (queue.contains(cities[i])) {
                queue.remove(cities[i]);
                queue.offer(cities[i]);
                answer += 1;
                continue;
            } else if (queue.size() < cacheSize && !queue.contains(cities[i])) {
                queue.offer(cities[i]);
                answer += 5;
                continue;
            } else if (queue.size() <= cacheSize) {
                queue.poll();
                queue.offer(cities[i]);
                answer += 5;
            }
        }
        return answer;
    }
}