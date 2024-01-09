import java.util.*;

//도시의 세로 도로는 모든 정수 x좌표마다 있고 가로도로는 y좌표마다 있다.
//세준 (0,0)에 있네..? (x,y에 위치한 집으로 가려고함)
//도로를 따라 가로나 세로로 한블록 움직여, 블록을 대각선으로 가로질러
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long answer = 0;
        long x = in.nextInt(); //음의 개수
        long y = in.nextInt(); //프렛 개수
        long w = in.nextInt(); //한블록 가는데 걸리는 시간
        long s = in.nextInt(); //대각선으로 가로지르는시간

        //수평으로만 이동하는 경우
        long math1 = (x + y) * w;
        long math2;
        long math3;
        //대각이동하는 경우
        if((x + y) % 2 == 0) {
            math2 = Math.max(x, y) * s;
        } else {
            math2 = (Math.max(x,y)-1) * s + w;
        }
        //대각 + 직선무빙
        math3 = (Math.min(x,y)) * s + (Math.abs(x-y)) * w;

        answer = Math.min(Math.min(math1, math2), math3);
        System.out.println(answer);
    }
}

