import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Solution {
    public String solution(String X, String Y) {
        char[] a = X.toCharArray();
        char[] b = Y.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        StringBuilder sb = new StringBuilder();

        int xLen = X.length()-1;
        int yLen = Y.length()-1;

        while(xLen >= 0 || yLen >= 0) {
            if(a[xLen] == b[yLen]) {
                sb.append(a[xLen]);
                xLen--;
                yLen--;
            } else if(Math.max(a[xLen], b[yLen]) == a[xLen]) {
                xLen--;
            } else {
                yLen--;
            }
        }

        if(sb.length() == 0) {
            return "-1";
        } else {
            if(sb.toString().charAt(0) == '0') {
                return "0";
            }
        }
        return sb.toString();
    }
}