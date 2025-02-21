import java.io.*;
import java.util.*;

public class Main {
    static int h, w;
    static char[][] board;
    static int startX;
    static int startY;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dy = {0, 1, 0, -1};
    static Map<Integer, Character> directionMap = new HashMap<>();
    static Queue<int[]> queue = new LinkedList<>();
    static char dir;
    static int startIdx;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        boolean flag = false;
        visited = new boolean[h][w];
        board = new char[h][w];
        directionMap.put(0, '^'); directionMap.put(1, '>'); directionMap.put(2, 'v'); directionMap.put(3, '<');

        //board를 만든다.
        for (int i = 0; i < h; i++) {
            String str = br.readLine();
            for (int j = 0; j < w; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        //시작 지점을 찾는다.
        for(int i = 0; i < h; i++) {
            boolean check = false;
            for(int j = 0; j < w; j++) {
                if(board[i][j] == '#' && checkStartPoint(i, j)) {
                    startX = i + 1;
                    startY = j + 1;
                    check = true;
                    visited[i][j] = true;
                    queue.offer(new int[] {i, j, startIdx});
                    break;
                }
            }
            if(check) break;
        }
        bfs();
        System.out.println(startX + " " + startY);
        System.out.println(dir);
        System.out.print(sb.toString());
    }

    public static boolean checkStartPoint(int i, int j) {
        int count = 0;
        int dirIdx = 0;
        for(int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(nx >= 0 && ny >= 0 && nx < h && ny < w && board[nx][ny] == '#') {
                count++;
                dirIdx = k;
                startIdx = k;
            }
            if(count >= 2) return false;
        }
        if(count == 1){
            dir = directionMap.get(dirIdx);
            return true;
        }
        return false;
    }

    public static void bfs() {
        //현재 어딜보고 있는지
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int nowDir = now[2];
                //범위를 벗어나거나 방문했다면 넘어가기
                if(nx < 0 || ny < 0 || nx >= h || ny >= w || visited[nx][ny]) continue;
                if(board[nx][ny] == '.') continue;
                //같은 방향이고 갈 수 있다면 가야지!
                if(nowDir == i) {
                    sb.append("A");
                    visited[nx][ny] = true;
                    visited[nx + dx[i]][ny + dy[i]] = true;
                    queue.offer(new int[] {nx + dx[i], ny + dy[i], nowDir});
                }
                //방향이 다르다면 회전하고 전진
                //북 동 남 서 0 1 2 3
                if(nowDir != i) {
                    //북쪽으로 가다가
                    if(nowDir == 0) {
                        if(i == 1) sb.append("R").append("A");
                        if(i == 3) sb.append("L").append("A");
                    }
                    if(nowDir == 1) {
                        if(i == 0) sb.append("L").append("A");
                        if(i == 2) sb.append("R").append("A");
                    }
                    if(nowDir == 2) {
                        if(i == 1) sb.append("L").append("A");
                        if(i == 3) sb.append("R").append("A");
                    }
                    if(nowDir == 3) {
                        if(i == 0) sb.append("R").append("A");
                        if(i == 2) sb.append("L").append("A");
                    }

                    visited[nx][ny] = true;
                    visited[nx + dx[i]][ny + dy[i]] = true;
                    queue.offer(new int[] {nx + dx[i], ny + dy[i], i});
                }
            }
        }
    }
}
