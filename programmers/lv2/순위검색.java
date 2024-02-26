import java.util.*;
class Solution {
    Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for(int i = 0; i < info.length; i++) {
            String[] p = info[i].split(" ");
            dfs(p,"",0);
        }
        //오름차순 정렬한다
        for(String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        for(int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" "); //q[0] => 쿼리 q[1]는 점수
            if(!map.containsKey(q[0])) {
                answer[i] = 0;
            } else {
                answer[i] = binarySearch(q[0], Integer.parseInt(q[1]));
            }
        }
        return answer;
    }

    private int binarySearch(String key, int target) {
        List<Integer> arr = map.get(key);
        int start = 0;
        int end = arr.size() -1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(arr.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return arr.size() - start;
    }
    //모든 조합의 수를 만들자
    private void dfs(String[] p, String tmp, int depth) {
        if(depth == 4) {
            if(!map.containsKey(tmp)) {
                map.put(tmp, new ArrayList<>());
            }
            map.get(tmp).add(Integer.parseInt(p[4]));
            return;
        }
        dfs(p, tmp + "-", depth + 1);
        dfs(p, tmp + p[depth], depth + 1);
    }
}