import java.util.*;

class Solution {
    static List<List<String>> list = new ArrayList<>();
    public static long solution(String expression) {
        long answer = 0;

        boolean[] visited = new boolean[3];
        List<Long> num = new ArrayList<>();
        List<String> ops = new ArrayList<>();

        String[] op = {"*", "-", "+"};

        //연산자 우선순위를 위해 조합을 만들자
        dfs(new ArrayList<>(), op, visited);
        //연산자와 숫자를 구분해서 넣어보자
        int start = 0;
        for(int i = 0 ; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if(ch == '-' || ch == '+' || ch == '*') {
                ops.add(String.valueOf(ch));
                num.add(Long.parseLong(expression.substring(start, i)));
                start = i + 1;
            }
        }
        num.add(Long.parseLong(expression.substring(start)));

        for(List<String> lists : list) {
            answer = Math.max(answer, solve(lists, num, ops));
        }
        return answer;
    }
    //연산자 조합을 만드는 dfs
    static void dfs(List<String> arr, String[] op, boolean[] visited) {
        if(arr.size() == 3) {
            list.add(arr);
            return;
        }

        for(int i = 0; i < op.length; i++) {
            if(!visited[i]) {
                ArrayList<String> tmp = new ArrayList<>(arr);
                tmp.add(op[i]);
                visited[i] = true;
                dfs(tmp, op, visited);
                visited[i] = false;
            }
        }
    }

    static long solve(List<String> lists, List<Long> num, List<String> ops) {
        List<Long> numClone = new ArrayList<>(num);
        List<String> opsClone = new ArrayList<>(ops);

        for(int i = 0; i < lists.size(); i++) {
            String op = lists.get(i);
            for(int j = 0; j < opsClone.size(); j++) {
                if(op.equals(opsClone.get(j))) {
                    long a = numClone.get(j);
                    long b = numClone.get(j + 1);
                    long cal = calc(a, b, op);

                    numClone.remove(j + 1);
                    numClone.remove(j);

                    opsClone.remove(j);
                    numClone.add(j, cal);
                    j--;
                }
            }
        }
        return Math.abs(numClone.get(0));
    }

    static long calc(long a, long b, String op) {
        switch(op) {
            case "-" :
                return a - b;
            case "+" :
                return a + b;
            default :
                return a * b;
        }
    }
}