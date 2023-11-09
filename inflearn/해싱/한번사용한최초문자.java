import java.util.HashMap;

class Solution {
    public int solution(String s){
        int answer = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
        }

        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) {
                return i + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}