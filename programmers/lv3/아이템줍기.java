import java.util.*;
class Solution {
    int[][] board = new int[101][101];
    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};
    int answer = 0;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for(int[] rect : rectangle) {
            int startX = rect[1] * 2;
            int endX = rect[3] * 2;
            int startY = rect[0] * 2;
            int endY = rect[2] * 2;
            for(int i = startX; i <= endX; i++) {
                for(int j = startY; j <= endY; j++) {
                    if(i == endX || i == startX || j == startY || j == endY) {
                        if(board[i][j] == 2) continue;
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 2;
                    }
                }
            }
        }
        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        return answer;
    }

    public void bfs(int characterX, int characterY, int itemX, int itemY) {
        boolean[][] visited = new boolean[101][101];
        visited[characterY][characterX] = true; //방문 완료
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {characterY, characterX, 0});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            if(now[0] == itemY && now[1] == itemX) {
                answer = now[2] / 2;
                return;
            }
            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx < 0 || ny < 0 || nx > 100 || ny > 100) continue;
                if(board[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny, now[2] + 1});
                }
            }
        }
    }
}
