class Solution {
    static private int[] lion = new int[11];
    static private int[] answer;
    static private int max = Integer.MIN_VALUE;

    public int[] solution(int n, int[] info) {
        dfs(0,n,info);
        if(max == -1) {
            answer = new int[1];
            answer[0] = -1;
        }
        return answer;
    }

    public static void dfs(int depth, int n, int[] info) {
        //라이언이 화살을 다 쐈으면 비교한다.
        if(depth == n) {
            int dif = score(info);
            if(max <= dif) {
                max = dif;
                answer = lion.clone();
            }
            return;
        }
        //다음화살 쏘러가즈아
        for(int i = 0; i < info.length && lion[i] <= info[i]; i++) {
            lion[i] += 1;
            dfs(depth + 1, n, info);
            lion[i] -= 1;
        }
    }

    public static int score(int[] info) {
        int ap = 0, li = 0;
        for(int i = 0; i < 11; i++) {
            if(lion[i] == 0 && info[i] == 0) continue;
            if(info[i] >= lion[i]) {
                ap += (10 - i);
            } else {
                li += (10 - i);
            }
        }
        int dif = li - ap;
        if(dif <= 0) return -1;
        return dif;
    }
}