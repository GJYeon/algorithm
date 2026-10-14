import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<List<Integer>> stack = new Stack<>();
        
        for (int i = 0 ; i < prices.length ; i++) {
            if (stack.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                list.add(prices[i]);
                list.add(i);
                stack.push(list);
            } else {
                if (stack.peek().get(0) <= prices[i]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(prices[i]);
                    list.add(i);
                    stack.push(list);
                } else {
                    while (!stack.isEmpty() && stack.peek().get(0) > prices[i]) {
                        List<Integer> price = stack.pop();
                        answer[price.get(1)] = i - price.get(1);
                    }
                    List<Integer> list = new ArrayList<>();
                    list.add(prices[i]);
                    list.add(i);
                    stack.push(list);
                }
            }   
        }
        
        while (!stack.isEmpty()) {
            List<Integer> price = stack.pop();
            answer[price.get(1)] = prices.length - 1 - price.get(1);
            
        }
        
        
        return answer;
    }
}