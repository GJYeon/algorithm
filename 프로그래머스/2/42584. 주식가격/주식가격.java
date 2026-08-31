import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        for (int i = 0 ; i < prices.length ; i++) {
            if (stack.isEmpty()) {
                stack.push(prices[i]);
                stack2.push(i);
            } else {
                if (stack.peek() <= prices[i]) {
                    stack.push(prices[i]);
                    stack2.push(i); 
                } else {
                    while (!stack.isEmpty() && stack.peek() > prices[i]) {
                        stack.pop();
                        int a = stack2.pop();
                        answer[a] = i - a;
                    }
                    stack.push(prices[i]);
                    stack2.push(i);
                }
            }
        }
        
        while (!stack.isEmpty()) {
            stack.pop();
            int a = stack2.pop();
            answer[a] = prices.length - 1 - a;
        }
        
        
        return answer;
    }
}