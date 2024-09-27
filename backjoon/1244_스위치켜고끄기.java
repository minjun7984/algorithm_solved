import java.util.*;

public class Main {
    public static void main(String[] args) {
        //남학생은 스위치 번호가 자기 받은 수 배수면 상태 바꿈
        //여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 좌우가 대칭이면서 가장 많은 스위치 포함 구간 찾아 상태바꾼다 구간에 속한 스위치는 항상 홀수
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] switchs = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            switchs[i] = in.nextInt();
        }
        int studentNum = in.nextInt();
        for(int i = 0; i < studentNum; i++) {
            int gender = in.nextInt();
            int number = in.nextInt();

            if(gender == 1) {
                for(int j = 1; j <= n; j++) {
                    if(j % number == 0) {
                        switchs[j] = switchs[j] == 0 ? 1 : 0;
                    }
                }
            }

            if(gender == 2) {
                int start = number - 1;
                int end = number + 1;
                while(start >= 1 && end <= n) {
                    if(switchs[start] == switchs[end]) {
                        switchs[start] = switchs[start] == 0 ? 1 : 0;
                        switchs[end] = switchs[end] == 0 ? 1 : 0;
                        start--;
                        end++;
                    } else {
                        break;
                    }
                }
                switchs[number] = switchs[number] == 0 ? 1 : 0;
            }
        }
        //남 1 여 2
        for(int i = 1; i <= n; i++) {
            System.out.print(switchs[i] + " ");
            if(i % 20 == 0) System.out.println();
        }
    }
}

