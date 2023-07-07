class Solution {
    public int solution(int n) {
        //연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다라는 정수론
        int answer = 0;
        int cnt = 1;
        n--;
        while(n > 0) {
            cnt++;
            n = n - cnt;
            if(n % cnt == 0) {
                answer++;
            }
        }
        return answer;
    }
}