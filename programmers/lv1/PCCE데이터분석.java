import java.util.*;

class Solution {
    static int sortIdx = 0;
    static int extIdx = 0;
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<int[]> arr = new ArrayList<>();

        String[] s = {"code", "date","maximum","remain"};

        for(int i = 0; i < s.length; i++) {
            if(ext.equals(s[i])) extIdx = i;
            if(sort_by.equals(s[i])) sortIdx = i;
        }

        for(int i = 0; i < data.length; i++) {
            if(data[i][extIdx] < val_ext) {
                arr.add(data[i]);
            }
        }

        Collections.sort(arr, (o1,o2) -> o1[sortIdx] - o2[sortIdx]);

        int[][] answer = new int[arr.size()][4];
        for(int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}