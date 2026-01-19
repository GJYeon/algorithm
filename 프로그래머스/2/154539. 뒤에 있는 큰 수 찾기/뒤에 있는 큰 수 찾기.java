import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackTmp = new Stack<>();
        stack.push(numbers[0]);
        stackTmp.push(0);
        for (int i = 1; i< numbers.length ; i++) {
            if (!stack.isEmpty() && stack.peek() < numbers[i]){
                while (!stack.isEmpty() && stack.peek() <numbers[i]) {
                    answer[stackTmp.pop()] = numbers[i];
                    stack.pop();
                }
                stack.push(numbers[i]);
                stackTmp.push(i);
            } else {
                stack.push(numbers[i]);
                stackTmp.push(i);
            }
        }
        
        answer[numbers.length-1] = -1;
        
        return answer;
    }
}