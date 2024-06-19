import java.util.*;
class Solution {
    public int solution(int[] plantTime, int[] growTime) {
        int answer = 0;

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < plantTime.length; i++) {
            list.add(new int[]{(plantTime[i] - growTime[i]), growTime[i], i});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });

        int start = 0;
        int end = 0;
        for (int i = 0; i < list.size(); i++) {
            int index = list.get(i)[2];
            start += plantTime[index];
            end = Math.max(end, start + growTime[index]);
        }
        return end;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}