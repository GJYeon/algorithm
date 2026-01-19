import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> frontSet = new HashSet<>();
        int[] frontArr = new int[topping.length];
        Set<Integer> backSet = new HashSet<>();
        int[] backArr = new int[topping.length];
        for (int i = 0; i < topping.length ; i++) {
            frontSet.add(topping[i]);
            frontArr[i] = frontSet.size();
        }
        for (int i = topping.length-1 ; i >= 0; i--){
            backSet.add(topping[i]);
            backArr[i] = backSet.size();
        }
        for (int i = 0 ; i < topping.length-1 ; i++) {
            if (frontArr[i] == backArr[i+1]) {
                answer += 1;
            }
        }
        return answer;
    }
}