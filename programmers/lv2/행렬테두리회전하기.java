class Solution {
    static int[][] map;
    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows+1][columns+1];
        int[] answer = new int[queries.length];
        int count = 1;
        //행렬에 값을 채운다..!
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++) {
                map[i][j] = count;
                count++;
            }
        }
        //회전하면서 최소값 찾자
        for(int i = 0; i < queries.length; i++) {
            int min = rotation(map, queries[i]);
            answer[i] = min;
        }
        return answer;
    }
    //회전하며 최소값 반환
    public int rotation(int[][] mp, int[] queries) {
        int dx[] = {0,1,0,-1};
        int dy[] = {1,0,-1,0};
        int d = 0;

        int xStart = queries[0]; int xEnd = queries[2];
        int yStart = queries[1]; int yEnd = queries[3];
        int min = map[xStart][yStart];
        int t = map[xStart][yStart];

        int x = xStart;
        int y = yStart;

        while(true) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx > xEnd || ny > yEnd || nx < xStart || ny < yStart) {
                d = (d+1) % 4;
                continue;
            }
            int tmp = map[nx][ny];
            map[nx][ny] = t;
            t = tmp;

            x = nx;
            y = ny;

            min = Math.min(min, t);
            if(x == xStart && y == yStart) break;
        }
        return min;
    }
}