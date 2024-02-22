import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets,(a,b)->(a[1]-b[1]));

        int end = targets[0][1];

        for(int[] target:targets){

            int t_start = target[0];
            int t_end = target[1];

            if(end<=t_start){

                end=t_end;
                answer++;

            }
        }
        return answer+1;
    }
}