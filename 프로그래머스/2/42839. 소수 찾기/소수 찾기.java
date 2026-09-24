import java.util.*;
class Solution {
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        boolean[] visited = new boolean[numbers.length()];
        
        for (int i = 0 ; i < numbers.length() ; i++) {
            String str = "";
            visited[i] = true;
            str += numbers.charAt(i);
            set.add(Integer.parseInt(str));
            check(visited, numbers, str);
            visited[i] = false;
        }
        for (Integer num : set) {
            if (num < 2) {
                continue;
            }
            boolean isSosu = true;
            for (int i = 2 ; i < num ; i++) {
                if (num % i == 0) {
                    isSosu = false;
                    break;
                } 
            }
            if (isSosu == true) {
                answer += 1;
            }
        }
        
        return answer;
    }
    
    public void check(boolean[] visited, String numbers, String str) {
        for (int i = 0 ; i < numbers.length() ; i++) {
            if (visited[i] == false) {
                String temp = "";
                for (int j = 0 ; j < str.length() ; j++) {
                    temp += str.charAt(j);
                }
                visited[i] = true;
                temp += numbers.charAt(i);
                set.add(Integer.parseInt(temp));
                check(visited, numbers, temp);
                visited[i] = false;
            }
        }
    }
}