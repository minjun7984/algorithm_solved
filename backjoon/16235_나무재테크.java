import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static Deque<int[]> queue;
    static Queue<int[]> dieTreeQueue;
    static Queue<int[]> addTreeQueue;
    static int[][] board;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] nutrient;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();
        dieTreeQueue = new LinkedList<>();
        addTreeQueue = new LinkedList<>();

        board = new int[n][n];
        nutrient = new int[n][n];

        //시작 양분은 5이다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 5;
            }
        }

        //겨울 양분주는 값
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                nutrient[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //나무를 심자
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1; //나무 x좌표
            int y = Integer.parseInt(st.nextToken()) - 1; //나무 y좌표
            int z = Integer.parseInt(st.nextToken()); //나이
            queue.offer(new int[]{x, y, z});
        }
        //k년의 시간을 보낸다.
        for (int i = 0; i < k; i++) {
            spring();
            summer();
            fall();
            winter();
        }
        System.out.println(queue.size());
    }

    public static void spring() {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int[] tree = queue.poll();
            //양분이 부족해서 못먹으면 죽음
            if (board[tree[0]][tree[1]] - tree[2] < 0) {
                dieTreeQueue.offer(tree);
                continue;
            }

            if ((tree[2] + 1) % 5 == 0) {
                board[tree[0]][tree[1]] -= tree[2];
                addTreeQueue.offer(new int[]{tree[0], tree[1], tree[2] + 1});
                queue.offer(new int[]{tree[0], tree[1], tree[2] + 1});
                continue;
            }

            board[tree[0]][tree[1]] -= tree[2];
            queue.offer(new int[]{tree[0], tree[1], tree[2] + 1});
        }
    }

    public static void summer() {
        while (!dieTreeQueue.isEmpty()) {
            int[] dieTree = dieTreeQueue.poll();
            board[dieTree[0]][dieTree[1]] += (dieTree[2] / 2);
        }
    }

    public static void fall() {
        while (!addTreeQueue.isEmpty()) {
            int[] addTree = addTreeQueue.poll();
            for (int j = 0; j < 8; j++) {
                int nx = addTree[0] + dx[j];
                int ny = addTree[1] + dy[j];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                queue.addFirst(new int[]{nx, ny, 1});
            }
        }
    }

    public static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] += nutrient[i][j];
            }
        }
    }
}

