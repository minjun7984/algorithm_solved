import java.util.*;

public class Main {
    public static void main(String[] args) {
        //상위 4명
        //가장 낮은 점수 얻는 팀이 우승
        //6명이 안되면 제외
        //동점일 경우 5번째주자
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t > 0) {
            t--;
            int n = in.nextInt();
            int[] matrix = new int[n];
            int[] teamCount = new int[n + 1];

            HashMap<Integer, int[]> map = new HashMap<>();
            //6명 인원이 들어가는지 확인하자
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                matrix[i] = num;
                teamCount[num]++;

                if (teamCount[num] == 6) {
                    map.put(num, new int[]{0, 0, 0}); // score // 4명 도달했는지 // 5번짼 누구인지
                }
            }


            int score = 1;

            for (int i = 0; i < n; i++) {
                int team = matrix[i];
                // 6명이 넘는 팀만 처리
                if (map.containsKey(team)) {
                    int[] teamInfo = map.get(team);
                    // 상위 4명까지의 점수 합산
                    if (teamInfo[1] < 4) {
                        teamInfo[0] += score;
                        teamInfo[1]++;
                    }
                    // 5번째 주자의 점수 저장
                    else if (teamInfo[1] == 4) {
                        teamInfo[2] = score;
                        teamInfo[1]++; // 5번째 주자 처리 완료
                    }
                    score++;
                }
            }

            int minScore = Integer.MAX_VALUE;
            int minFifthRunner = Integer.MAX_VALUE;
            int answer = -1;

            for (int key : map.keySet()) {
                int[] teamInfo = map.get(key);
                int teamScore = teamInfo[0]; // 팀 총 스코어
                int fifthRunnerScore = teamInfo[2];

                if (teamScore < minScore) {
                    minScore = teamScore;
                    minFifthRunner = fifthRunnerScore;
                    answer = key;
                } else if (teamScore == minScore) {
                    if (fifthRunnerScore < minFifthRunner) {
                        minFifthRunner = fifthRunnerScore;
                        answer = key;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}

