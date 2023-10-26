import java.util.*;
class Solution {
    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];
        int n = board.length;
        //방향 전환
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int d = 0;
        int x = 0, y = 0;
        int count = 0;

        while(count < k) {
            count++;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1) {
                d = (d + 1) % 4;
            } else {
                x = nx;
                y = ny;
            }
        }
        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}