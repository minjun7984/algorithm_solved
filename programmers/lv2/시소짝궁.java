import java.util.*;
class Solution {
    public long solution(int[] weights) {
        //탑승한 사람의 무게와 * 시소 축과 좌석 간의 거리의 곱이 같다면 시소짝궁
        long answer = 0;
        Arrays.sort(weights);
        //카운팅 조건
        //a == b,  //a * 4 == b *2,
        //a * 3 == b * 2, //a * 4 == b * 3;
        //이미 a <= b인 상태(정렬했기 때문이다.) 다른 조건은 보지 않아도 됨
        int pre = 0;
        for(int i = 0; i < weights.length -1; i++) {
            if(i > 0 && weights[i] == weights[i-1]) {
                pre--;
                answer += pre;
                continue;
            }
            int maxIdx = binarySearch(weights, weights[i], i+1);
            pre = 0;
            for(; maxIdx > i; maxIdx--) {
                if(weights[i] == weights[maxIdx] ||
                        weights[i] * 4 == weights[maxIdx] * 2 ||
                        weights[i] * 3 == weights[maxIdx] * 2 ||
                        weights[i] * 4 == weights[maxIdx] * 3) {
                    pre++;
                }
            }
            answer += pre;
        }
        return answer;
    }
    //이진탐색
    public int binarySearch(int[] weights, int num, int i) {
        int left = i;
        int right = weights.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(weights[mid] > num * 2) return mid;
            else left = mid + 1;
        }
        return left;
    }
}