import java.util.*;
class Solution {
    public int[] solution(String[] maps) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>(); // 완성된 무인도 값 저장
        char[][] map = new char[maps.length][maps[0].length()]; //맵
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }

        boolean[][] visited = new boolean[maps.length][maps[0].length()]; //방문 배열
        //사방탐색
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};

        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                if(visited[i][j] || map[i][j] == 'X') continue;
                queue.offer(new int[] {i,j});
                visited[i][j] = true;

                int sum = map[i][j] - '0';

                while(!queue.isEmpty()) {
                    int qs = queue.size();
                    for(int s = 0; s < qs; s++) {
                        int[] tmp = queue.poll();
                        for(int d = 0; d < 4; d++) {
                            int nx = tmp[0] + dx[d];
                            int ny = tmp[1] + dy[d];
                            //범위를 벗어나거나 방문한 곳, 바다라면 out
                            if(nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length() || visited[nx][ny] == true) continue;
                            if(map[nx][ny] == 'X') continue;
                            //섬이라면?
                            sum += (map[nx][ny] - '0');
                            queue.offer(new int[] {nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
                arr.add(sum);
                Collections.sort(arr);
            }
        }
        int len = arr.size();
        if(len == 0) return new int[] {-1};
        answer = new int[len];

        for(int i = 0; i < len; i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}