import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        for(int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase();
        }

        Queue<String> queue = new LinkedList<>();
        int time = 0;

        for(int i = 0; i < cities.length; i++) {
            if(cacheSize == 0) return cities.length * 5;
            if(queue.size() == 0) {
                time += 5;
                queue.offer(cities[i]);
                continue;
            }
            if(queue.contains(cities[i])) {
                queue.remove(cities[i]);
                queue.offer(cities[i]);
                time += 1;
                continue;
            }
            else if(queue.size() < cacheSize && !queue.contains(cities[i])) {
                queue.offer(cities[i]);
                time += 5;
                continue;
            }
            else if(queue.size() <= cacheSize) {
                queue.poll();
                queue.offer(cities[i]);
                time += 5;
                continue;
            }
        }
        return time;
    }
}