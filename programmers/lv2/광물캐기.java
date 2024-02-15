import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {

        int cnt = Math.min(minerals.length / 5 + 1, picks[0]+ picks[1] + picks[2]);
        int answer = 0;
        int dCnt = 0, iCnt = 0, sCnt = 0;
        int[][] section = new int[cnt][3];

        for(int i = 0; i < minerals.length; i += 5) {
            if(i / 5 == cnt) {
                break;
            }
            for(int j = i; j < i + 5; j++) {
                String s = minerals[j];
                if(s.equals("diamond")) {
                    dCnt += 1;
                    iCnt += 5;
                    sCnt += 25;
                }
                else if(s.equals("iron")) {
                    dCnt += 1;
                    iCnt += 1;
                    sCnt += 5;
                }
                else {
                    dCnt += 1;
                    iCnt += 1;
                    sCnt += 1;
                }
                if(j == minerals.length-1) {
                    break;
                }
            }
            section[i / 5][0] = dCnt;
            section[i / 5][1] = iCnt;
            section[i / 5][2] = sCnt;
            dCnt = iCnt = sCnt = 0;
        }

        //돌로 캘 때 피로도 내림차순 정렬한다.
        Arrays.sort(section,(o1, o2) -> o2[2] - o1[2]);

        for(int i = 0; i < cnt; i++) {
            if(picks[0] != 0) {
                answer += section[i][0];
                picks[0]--;
            }
            else if(picks[1] != 0) {
                answer += section[i][1];
                picks[1]--;
            }
            else if(picks[2] != 0) {
                answer += section[i][2];
                picks[2]--;
            }
        }
        return answer;
    }
}