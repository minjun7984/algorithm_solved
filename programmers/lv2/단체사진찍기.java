class Solution {
    boolean[] check = new boolean[8];
    String[] alpha = new String[8];
    int answer = 0;

    public int solution(int n, String[] data) {
        String str = "ACFJMNRT";
        int target = 8;
        int cnt = 0;
        for (char c : str.toCharArray()) {
            alpha[cnt] = String.valueOf(c);
            cnt++;
        }

        dfs(0, "", target, data);
        return answer;
    }

    public void dfs(int depth, String str, int target, String[] data) {
        if (depth == target) {
            if (checkData(str, data)) answer++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (check[i] == false) {
                check[i] = true;
                dfs(depth + 1, str + alpha[i], target, data);
                check[i] = false;
            }
        }
    }

    public boolean checkData(String str, String[] data) {

        for (int i = 0; i < data.length; i++) {
            char requestFriend = data[i].charAt(0);
            char receiveFriend = data[i].charAt(2);
            char sign = data[i].charAt(3);
            int count = Integer.parseInt(data[i].charAt(4) + "");

            int reF = str.indexOf(requestFriend);
            int reC = str.indexOf(receiveFriend);

            int dif = Math.abs(reF - reC) - 1;

            if (sign == '>') {
                if (dif <= count) return false;
            } else if (sign == '<') {
                if (dif >= count) return false;
            } else if (sign == '=') {
                if (dif != count) return false;
            }

        }
        return true;
    }
}