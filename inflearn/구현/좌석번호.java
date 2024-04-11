import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int[] solution(int c, int r, int k) {
        int[] answer = new int[2];
        if (k > c * r) return new int[]{0, 0};
        int[][] map = new int[c][r];
        int start = 1;
        int x = 0;
        int y = 0;
        int d = 0;

        while (start < k) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= c || ny < 0 || ny >= r || map[nx][ny] > 0) {
                d = (d + 1) % 4;
                continue;
            }
            map[x][y] = start;
            start++;
            x = nx;
            y = ny;
        }
        answer[0] = x + 1;
        answer[1] = y + 1;
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}