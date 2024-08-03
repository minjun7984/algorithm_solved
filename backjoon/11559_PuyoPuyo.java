import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] board = new char[12][6];
    static int answer = 0;
    static boolean flag;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 12; i++) {
            String str = in.next();
            for (int j = 0; j < 6; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        // 반복적으로 뿌요를 제거하고 중력을 적용
        while (true) {
            flag = false; // flag 초기화
            boolean[][] visited = new boolean[12][6]; // 방문 배열 초기화

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (board[i][j] != '.' && !visited[i][j]) {
                        check(i, j, board[i][j], visited);
                    }
                }
            }

            if (!flag) {
                break; // 더 이상 제거할 뿌요가 없으면 종료
            }
            dropPuyo();
            answer++;
        }
        System.out.print(answer);
    }

    private static void check(int startX, int startY, char ch, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<int[]> list = new ArrayList<>();

        queue.offer(new int[]{startX, startY});
        list.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < 12 && ny < 6 && board[nx][ny] == ch && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    list.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }

        if (count >= 4) {
            flag = true;
            for (int[] pos : list) {
                board[pos[0]][pos[1]] = '.';
            }
        }
    }

    private static void dropPuyo() {
        for (int i = 0; i < 6; i++) { // 각 열에 대해 중력 적용
            Queue<Character> queue = new LinkedList<>();
            for (int j = 11; j >= 0; j--) {
                if (board[j][i] != '.') {
                    queue.offer(board[j][i]);
                }
            }
            for (int j = 11; j >= 0; j--) {
                if (!queue.isEmpty()) {
                    board[j][i] = queue.poll();
                } else {
                    board[j][i] = '.';
                }
            }
        }
    }
}
