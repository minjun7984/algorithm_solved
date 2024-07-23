import java.util.*;

public class Main {
    static char[] tmp;
    static boolean[] visited;
    static int L;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        L = in.nextInt(); //암호의 길이
        int C = in.nextInt(); //문자의 종류
        tmp = new char[C];
        visited = new boolean[C];

        for (int i = 0; i < C; i++) {
            tmp[i] = in.next().charAt(0);
        }
        Arrays.sort(tmp);
        dfs("");
    }

    public static void dfs(String s) {
        if (s.length() >= 2 && s.charAt(s.length() - 1) < s.charAt(s.length() - 2)) return;
        if (s.length() == L && check(s)) {
            System.out.println(s);
        }

        for (int i = 0; i < tmp.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(s + tmp[i]);
                visited[i] = false;
            }
        }
    }

    //모음 개수 자음 개수가 맞는지 확인하는 메서드
    public static boolean check(String s) {
        char[] ch = {'a', 'e', 'i', 'o', 'u'};
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 5; j++) {
                if (s.charAt(i) == ch[j]) count++;
            }
        }
        if (count == 0 || s.length() - count < 2) return false;
        return true;
    }
}
