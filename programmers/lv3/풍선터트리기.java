class Solution {
    public int solution(int[] a) {
        int[] left = new int[a.length];
        int[] right = new int[a.length];

        int leftMin = a[0];
        int rightMin = a[a.length - 1];

        for(int i = 1; i < a.length -1; i++) {
            if(leftMin > a[i]) leftMin = a[i];
            left[i] = leftMin;
        }

        for(int i = a.length -2; i > 0; i--) {
            if(rightMin > a[i]) rightMin = a[i];
            right[i] = rightMin;
        }

        if(a.length == 1) return 1;
        int answer = 2;
        for(int i = 1; i <= a.length - 2; i++) {
            if(a[i] > left[i] && a[i] > right[i]) continue;
            answer++;
        }

        return answer;
    }
}