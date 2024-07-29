import java.util.*;

public class Main {
    static int[][] board;
    static int r, c, target;

    static class Pair implements Comparable<Pair> {
        int num;
        int count;

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Pair p) {
            if (this.count == p.count) {
                return this.num - p.num;
            } else {
                return this.count - p.count;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        r = in.nextInt() - 1; //a[r][c] 의 값이 k가 되기 위한 최소시간
        c = in.nextInt() - 1;
        target = in.nextInt(); //100초가지나도 안되면 -1
        board = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = in.nextInt();
            }
        }

        int time = 0;
        while (true) {
            if (time > 100) {
                System.out.print(-1);
                break;
            }
            if (board.length > r && board[0].length > c) {
                if (board[r][c] == target) {
                    System.out.println(time);
                    break;
                }
            }

            if (board.length >= board[0].length) calculateR();
            else calculateC();
            time++;
        }
    }

    public static void calculateR() {
        int[][] copy_board = new int[101][101];
        int max = 0;

        for (int i = 0; i < board.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) continue;
                map.put(board[i][j], map.getOrDefault(board[i][j], 0) + 1);
            }

            ArrayList<Pair> list = new ArrayList<>();
            for (int key : map.keySet()) {
                list.add(new Pair(key, map.get(key)));
            }
            Collections.sort(list);

            int k = 0;
            for (int j = 0; j < list.size(); j++) {
                copy_board[i][k] = list.get(j).num;
                copy_board[i][k + 1] = list.get(j).count;
                k += 2;
            }
            max = Math.max(max, k);
            if (max > 100) max = 100;
        }

        board = new int[board.length][max];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < max; j++) {
                board[i][j] = copy_board[i][j];
            }
        }
    }

    public static void calculateC() {
        int[][] copy_board = new int[101][101];
        int max = 0;

        for (int i = 0; i < board[0].length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == 0) continue;
                map.put(board[j][i], map.getOrDefault(board[j][i], 0) + 1);
            }

            ArrayList<Pair> list = new ArrayList<>();
            for (int key : map.keySet()) {
                list.add(new Pair(key, map.get(key)));
            }

            Collections.sort(list);
            int k = 0;
            for (int j = 0; j < list.size(); j++) {
                copy_board[k][i] = list.get(j).num;
                copy_board[k + 1][i] = list.get(j).count;
                k += 2;
            }
            max = Math.max(max, k);
            if (max > 100) max = 100;
        }
        board = new int[max][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = copy_board[i][j];
            }
        }
    }
}


