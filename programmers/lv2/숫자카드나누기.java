import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int aGcd = arrayA[0];
        int bGcd = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            aGcd = gcd(aGcd, arrayA[i]);
            bGcd = gcd(bGcd, arrayB[i]);
        }

        int aCount = 0;
        int bCount = 0;
        boolean aFlag = true;
        boolean bFlag = true;
        for (int i = 0; i < arrayA.length; i++) {
            if (aFlag == false && bFlag == false) break;
            if (arrayA[i] % bGcd == 0) {
                aCount++;
                aFlag = false;
            }
            if (arrayB[i] % aGcd == 0) {
                bCount++;
                bFlag = false;
            }
        }

        if (aCount != 0 && bCount != 0) return 0;
        else if (aCount == 0 && bCount == 0) return Math.max(aGcd, bGcd);
        else if (aCount == 0) return bGcd;
        else return aGcd;
    }

    public int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}