class Solution {
    public long solution(int n) {
        //1칸 또는 2칸을 뛸 수 있다 칸이 총 4개있을 때 효진이는 5가지 방법으로 가능..
        //1234567로 나눈 나머지를 리턴하는 함수를 작성하라...4가 입력된다면 5를 return
        //dp 점화식 이용
        long[] d = new long[n+1];

        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        d[0] = 0;
        d[1] = 1L;
        d[2] = 2L;

        for(int i = 3; i<= n; i++) {
            d[i] = (d[i-1] + d[i-2]) % 1234567;
        }
        return d[n];
    }
}