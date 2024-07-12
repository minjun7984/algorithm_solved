import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        int answer = 0;
        int nowX = 0;
        int nowY = 0;

        for (char c : dirs.toCharArray()) {
            StringBuilder sb = new StringBuilder();
            int nextX = nowX;
            int nextY = nowY;

            if (c == 'U') {
                nextY++;
                sb.append(nowX).append(nowY).append(nextX).append(nextY);
            }

            if (c == 'D') {
                nextY--;
                sb.append(nextX).append(nextY).append(nowX).append(nowY);
            }

            if (c == 'R') {
                nextX++;
                sb.append(nowX).append(nowY).append(nextX).append(nextY);
            }

            if (c == 'L') {
                nextX--;
                sb.append(nextX).append(nextY).append(nowX).append(nowY);
            }

            if (nextX > 5 || nextX < -5 || nextY > 5 || nextY < -5) continue;
            set.add(sb.toString());
            nowX = nextX;
            nowY = nextY;
        }
        return set.size();
    }
}