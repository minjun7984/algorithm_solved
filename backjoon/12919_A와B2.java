import java.util.*;

public class Main {
    static String target;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        target = in.next();
        String S = in.next();
        boolean flag = dfs(S);

        if (flag == true) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }

    public static boolean dfs(String str) {
        if (str.length() == target.length()) {
            if (str.equals(target)) return true;
            return false;
        }

        if (str.charAt(str.length() - 1) == 'A') {
            if (dfs(str.substring(0, str.length() - 1))) {
                return true;
            }
        }

        if (str.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(str);
            if (dfs(sb.reverse().substring(0, str.length() - 1))) {
                return true;
            }
        }
        return false;
    }
}
