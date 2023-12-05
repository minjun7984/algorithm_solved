class Solution {
    public int solution(int storey) {
        //각 자리수를 0으로 만드는 것이 중요함...!
        int answer = 0;

        while (storey > 0) {
            int tmp = storey % 10;
            storey /= 10;
            //5일경우는 따져야 한다.
            if (tmp == 5) {
                if (storey % 10 >= 5) {
                    answer += 10 - tmp;
                    storey++;
                } else {
                    answer += tmp;
                }
            } else if (tmp > 5) {
                answer += 10 - tmp;
                storey++;
            } else {
                answer += tmp;
            }
        }
        return answer;
    }
}