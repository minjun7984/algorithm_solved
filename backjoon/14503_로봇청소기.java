import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};  // 북동남서
    static int[][] map;
    static int count = 0;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            //현재 칸이 아직 청소x면 청소
            if (map[r][c] == 0) {
                count++;
                map[r][c] = 2;
            }
            //4방향 청소되어있는지 확인하자
            boolean flag = true;
            for (int i = 0; i < 4; i++) {
                int nx = r + dx[i];
                int ny = c + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0) {
                        flag = false;
                    }
                }
            }
            //빈칸이 없는 경우
            if (flag) {
                int tmp = 0;
                if (d >= 2) tmp = d - 2;
                else tmp = d + 2;

                int nx = r + dx[tmp];
                int ny = c + dy[tmp];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 1) {
                    break;
                }
                r = nx;
                c = ny;
            } else {
                //반시계 90도 회전
                d = (d + 3) % 4;
                int nx = r + dx[d];
                int ny = c + dy[d];
                if (nx > 0 && ny > 0 && nx < N && ny < M && map[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                }
            }
        }
        System.out.println(count);
    }
}
