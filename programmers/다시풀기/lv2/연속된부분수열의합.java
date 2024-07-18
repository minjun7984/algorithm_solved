class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right = 1;
        int n = sequence.length;
        int len = Integer.MAX_VALUE;
        int sum = sequence[0];

        while (left < right) {
            if (sum > k) {
                sum -= sequence[left++];
                continue;
            } else if (sum < k && right < n) {
                sum += sequence[right++];
                continue;
            } else if (sum == k) {
                if (right - left < len) {
                    answer[0] = left;
                    answer[1] = right - 1;
                }
                len = Math.min(right - left, len);
                sum -= sequence[left++];
            } else {
                break;
            }
        }
        return answer;
    }
}