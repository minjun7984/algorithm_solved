import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        int index;
        int move = length - 1;

        for(int i = 0; i < length; i++) {
            //A에 가까워지는지 Z에 가까운지 확인
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            index = i + 1; //연속되는 알파벳 확인하자.

            while(index < length && name.charAt(index) == 'A') {
                index++;
            }
            //연속된 a개수 구하고 좌로 가는게 빠른가 우로 가는게 빠른가..!
            move = Math.min(move, i * 2 + length - index);
            move = Math.min(move, (length - index) * 2 + i);

        }
        return answer + move;
    }
}