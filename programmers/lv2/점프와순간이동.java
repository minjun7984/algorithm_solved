public class Solution {
    public int solution(int n) {
        //k칸을 앞으로 점프(k만큼 건전지 사용), 현재까지 온 거리 *2에 해당하는 위치로 순간이동(건전지 사용량 x)
        //주어진 값 계속 2로 나눈다
        //나머지가 없으면 그냥 2로 나누고 반복
        //나머지가 있으면 -1(1회 점프) 해 주고 반복

        int answer = 0;
        while(n > 0) {
            if(n % 2 != 0) {
                n -= 1;
                answer += 1;
            }
            n = n/2;
        }
        return answer;
    }
}