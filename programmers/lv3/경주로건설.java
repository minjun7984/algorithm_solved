import java.util.*;

class Solution {
    int n;
    int[][][] visited;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    class Node {
        public int x;
        public int y;
        public int dir;
        public int cost;

        Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

    public int solution(int[][] board) {
        int answer = 0;
        n = board.length;
        visited = new int[n][n][4];
        answer = bfs(board);
        return answer;
    }

    public int bfs(int[][] board) {
        Queue<Node> queue = new LinkedList<>();
        int x = 0, y = 0, dir = -1, cost = 0;
        queue.offer(new Node(x, y, dir, cost));

        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            //꺼낸것이 n-1위치라면 리턴스~
            if (node.x == n - 1 && node.y == n - 1) {
                min = Math.min(node.cost, min);
            }
            //4방향 탐색해보자
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
                    continue;
                }
                //자 다음곳 갈 수 있다!
                int nCost = node.cost;
                if (node.dir == -1 || node.dir == i) {
                    nCost += 100;
                } else {
                    nCost += 600;
                }

                if (visited[nx][ny][i] == 0 || board[nx][ny] >= nCost) {
                    queue.offer(new Node(nx, ny, i, nCost));
                    visited[nx][ny][i] = 1;
                    board[nx][ny] = nCost;
                }
            }
        }
        return min;
    }
}