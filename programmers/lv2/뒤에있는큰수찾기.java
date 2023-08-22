import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        //각 원소들이 자신보다 뒤에있는 숫자중 자신보다 크면서 가장 가까이 있는 수를 뒷큰수라고 한다.
        //뒷 큰수를 담은 배열을 구하라, 존재하지 않는 원소는 -1을 담는다.
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[numbers.length];

        stack.push(0);

        for (int i = 1; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while (stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}