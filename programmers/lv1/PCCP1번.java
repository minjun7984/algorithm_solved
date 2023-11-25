class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        //t초동안 붕대 감으며 1초마다 x회복
        //t초 연속 붕대 성공하면 y추가로 회복
        //bandage[0] = 시전시간 [1] 초당 회복, [2] 추가회복량
        //atack 공격시간 피해량
        int heelSuccessTime = 0;
        int t = bandage[0]; //시전 시간
        int x = bandage[1]; //초당 회복량
        int y = bandage[2]; // 추가 회복량
        int maxHealth = health;
        int attacksIdx = 0;

        for (int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
            //힐가능 상태
            boolean flag = true;
            //공격
            if (attacks[attacksIdx][0] == i) {
                health -= attacks[attacksIdx][1];
                attacksIdx++;
                heelSuccessTime = 0;
                flag = false;
            }
            //공격시 피가 음수가 되면 -1 리턴
            if (health <= 0) return -1;

            //체력이 max라면 힐 불가
            if (health == maxHealth) {
                flag = false;
                heelSuccessTime++;
            }

            //힐
            if (flag == true) {
                heelSuccessTime++;
                health += x;
                if (heelSuccessTime == t) {
                    health += y;
                    heelSuccessTime = 0;
                }
                if (health > maxHealth) {
                    health = maxHealth;
                }
            }
        }
        return health;
    }
}