import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        HashSet<String> set = new HashSet<>();

        int nowX = 0;
        int nowY = 0;

        for (char c : dirs.toCharArray()) {
            StringBuilder sb = new StringBuilder();
            int nextX = nowX;
            int nextY = nowY;

            if (c == 'U') {
                nextY++;
                sb.append(nowX);
                sb.append(nowY);
                sb.append(nextX);
                sb.append(nextY);
            } else if (c == 'L') {
                nextX--;
                sb.append(nextX);
                sb.append(nextY);
                sb.append(nowX);
                sb.append(nowY);
            } else if (c == 'D') {
                nextY--;
                sb.append(nextX);
                sb.append(nextY);
                sb.append(nowX);
                sb.append(nowY);
            } else if (c == 'R') {
                nextX++;
                sb.append(nowX);
                sb.append(nowY);
                sb.append(nextX);
                sb.append(nextY);
            }

            if (nextX < -5 || nextY < -5 || nextX > 5 || nextY > 5) {
                continue;
            }
            set.add(sb.toString());
            nowX = nextX;
            nowY = nextY;
        }

        return set.size();
    }
}