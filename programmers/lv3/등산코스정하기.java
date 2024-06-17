class Solution {
    int keyLen;
    int lockLen;

    public boolean solution(int[][] key, int[][] lock) {
        keyLen = key[0].length;
        lockLen = lock[0].length;
        int len = keyLen * 2 + lockLen - 2;
        int[][] map = new int[len][len];

        //확장시킨 map에 lock을 표시한다.
        for (int i = keyLen - 1; i < keyLen + lockLen - 1; i++) {
            for (int j = keyLen - 1; j < keyLen + lockLen - 1; j++) {
                map[i][j] = lock[i - (keyLen - 1)][j - (keyLen - 1)];
            }
        }

        //4방향 회전하고 회전할때마다 자물쇠 확인하고 원상복구 시키고...복잡스
        for (int i = 0; i < 4; i++) {
            if (check(map, key, lockLen)) {
                return true;
            }
            rotate(key);
        }
        return false;
    }

    public boolean check(int[][] map, int[][] key, int len) {
        for (int i = 0; i < map.length - keyLen + 1; i++) {
            for (int j = 0; j < map.length - keyLen + 1; j++) {
                //맵에다가 키의 값들을 더해주자
                for (int k = 0; k < keyLen; k++) {
                    for (int l = 0; l < keyLen; l++) {
                        map[i + k][j + l] += key[k][l];
                    }
                }
                //자물쇠 열리는지 확인하자
                boolean flag = true;
                for (int k = keyLen - 1; k < keyLen + lockLen - 1; k++) {
                    for (int l = keyLen - 1; l < keyLen + lockLen - 1; l++) {
                        if (map[k][l] != 1) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) break;
                }
                if (flag) return true;

                for (int k = 0; k < keyLen; k++) {
                    for (int l = 0; l < keyLen; l++) {
                        map[i + k][j + l] -= key[k][l];
                    }
                }

            }
        }
        return false;
    }

    public void rotate(int[][] key) {
        int[][] tmp = new int[keyLen][keyLen];

        for (int i = 0; i < keyLen; i++) {
            for (int j = 0; j < keyLen; j++) {
                tmp[i][j] = key[keyLen - j - 1][i];
            }
        }

        for (int i = 0; i < keyLen; i++) {
            for (int j = 0; j < keyLen; j++) {
                key[i][j] = tmp[i][j];
            }
        }
    }
}