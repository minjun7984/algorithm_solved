import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static Map<Integer, int[]> favoriteStudentMap;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        board = new int[n][n];
        favoriteStudentMap = new HashMap<>();

        //각 학생이 좋아하는 사람들 저장
        for (int i = 0; i < n * n; i++) {
            int nowStudent = in.nextInt();
            favoriteStudentMap.put(nowStudent, new int[4]);
            for (int j = 0; j < 4; j++) {
                favoriteStudentMap.get(nowStudent)[j] = in.nextInt();
            }
            //자리를 앉히자.
            putStudentSeat(nowStudent);
        }
        System.out.println(calculateCount());
        //계산하자.
    }

    private static void putStudentSeat(int studentNumber) {
        int[] favoriteStudents = favoriteStudentMap.get(studentNumber);
        List<Seat> availableSeats = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    int favoriteStudentCount = 0;
                    int emptyCount = 0;
                    //배정가능한 자리면 주변을 살피자
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                        //4방향중 누가 배정되어있다면 좋아하는 사람인지 확인하자.
                        if (board[nx][ny] != 0) {
                            for (int l = 0; l < 4; l++) {
                                if (board[nx][ny] == favoriteStudents[l]) favoriteStudentCount++;
                            }
                        } else {
                            emptyCount++;
                        }
                    }
                    //모두 확인 했으면 이용가능한 좌석에 추가
                    availableSeats.add(new Seat(i, j, favoriteStudentCount, emptyCount));

                }
            }
        }
        Collections.sort(availableSeats);
        board[availableSeats.get(0).x][availableSeats.get(0).y] = studentNumber;
    }

    private static int calculateCount() {
        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int studentNum = board[i][j];
                int[] favoriteStudents = favoriteStudentMap.get(studentNum);
                int count = 0;
                for(int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    for(int l = 0; l < 4; l++) {
                        if(board[nx][ny] == favoriteStudents[l]) count++;
                    }
                }
                switch (count) {
                    case 0: sum += 0; break;
                    case 1: sum += 1; break;
                    case 2: sum += 10; break;
                    case 3: sum += 100; break;
                    case 4: sum += 1000; break;
                }
            }
        }
        return sum;
    }

    static class Seat implements Comparable<Seat> {
        int x;
        int y;
        int favoriteStudentCount;
        int emptyCount;

        public Seat(int x, int y, int favoriteStudentCount, int emptyCount) {
            this.x = x;
            this.y = y;
            this.favoriteStudentCount = favoriteStudentCount;
            this.emptyCount = emptyCount;
        }

        @Override
        public int compareTo(Seat other) {
            if (this.favoriteStudentCount != other.favoriteStudentCount) {
                return Integer.compare(other.favoriteStudentCount, this.favoriteStudentCount);
            } else if (this.emptyCount != other.emptyCount) {
                return Integer.compare(other.emptyCount, this.emptyCount);
            } else if (this.x != other.x) {
                return Integer.compare(this.x, other.x);
            } else {
                return Integer.compare(this.y, other.y);
            }
        }
    }
}
