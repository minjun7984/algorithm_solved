import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    char map[][];
    int answer = 0;

    public int solution(int m, int n, String[] board) {
        map = new char[m][n];

        //char 배열 복사
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        while (countBlocks(m, n));
        return answer;
    }

    private boolean countBlocks(int m, int n) {
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        //모든 2 * 2 쌍을 찾는다..! visited에 기록된다!
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] == 'v') continue;
                if (check(i, j, map)) {
                    visited[i][j] = true;
                    visited[i][j + 1] = true;
                    visited[i + 1][j] = true;
                    visited[i + 1][j + 1] = true;
                }
            }
        }

        //갱신한다
        for (int i = 0; i < n; i++) {
            ArrayList<Character> arr = new ArrayList<>();
            for (int j = m - 1; j >= 0; j--) {
                if (visited[j][i] == true) {
                    count++;
                    continue;
                }
                arr.add(map[j][i]);
            }
            for (int j = m - 1, k = 0; j >= 0; j--, k++) {
                if (k < arr.size()) {
                    map[j][i] = arr.get(k);
                } else {
                    map[j][i] = 'v';
                }
            }
        }
        answer += count;
        return count > 0 ? true : false;
    }



    //2 x 2가 맞는지 확인하는 메서드
    public boolean check(int i, int j, char[][] map) {
        char ch = map[i][j];
        if(map[i][j+1] == ch && map[i+1][j] == ch && map[i+1][j+1] == ch) {
            return true;
        } else {
            return false;
        }
    }
}