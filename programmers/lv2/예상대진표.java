class Solution {
    public static int nextNum(int x) {
        if(x % 2 ==1) {
            x = x / 2 + 1;
        } else {
            x /= 2;
        }
        return x;
    }
    public int solution(int n, int a, int b) {
        int count = 1;

        while(Math.abs(a-b) != 1 || a/2 == b/2) {
            a = nextNum(a);
            b = nextNum(b);
            count++;
        }
        return count;
    }
}