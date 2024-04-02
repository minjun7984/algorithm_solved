class Solution {
    boolean[] visited;
    int answer = Integer.MAX_VALUE;

    public void dfs(String begin, String target, String[] words, int count) {
        if(begin.equals(target)) {
            answer = Math.min(answer, count);
            return;
        } else {
            for(int i = 0; i < words.length; i++) {
                if(visited[i]) continue;

                int cnt = 0;
                for(int j = 0; j < begin.length(); j++) {
                    if(begin.charAt(j) == words[i].charAt(j)) {
                        cnt++;
                    }
                }

                if(cnt == begin.length() -1) {
                    visited[i] = true;
                    dfs(words[i], target, words, count + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);
        if(answer == Integer.MAX_VALUE) return 0;
        return answer;
    }
}