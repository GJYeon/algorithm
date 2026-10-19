import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];
        for (int i = 0 ; i < numbers.length ; i++) {
            String s = String.valueOf(numbers[i]);
            str[i] = s;
        }
        
        Arrays.sort(str, (o1,o2) -> (o2 + o1).compareTo(o1+o2));
        for (int i = 0 ; i < numbers.length ; i++) {
            answer += str[i];
        }
        if (str[0].equals("0")) {
            return "0";
        }
        return answer;
    }
}