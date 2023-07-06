class Solution {
    public int[] solution(String[] wallpaper) {
        int height = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int bottom = Integer.MIN_VALUE;

        //왼쪽에서 제일 위 가장 오른쪽에서 가장아래
        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    right = Math.max(j, right);
                    left = Math.min(j, left);
                    bottom = Math.max(i, bottom);
                    height = Math.min(i, height);
                }
            }
        }

        return new int[] {height, left, bottom +1, right +1};
    }
}