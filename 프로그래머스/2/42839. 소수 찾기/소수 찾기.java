import java.util.*;
class Solution {
    Set<Integer> set= new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        boolean[] visited = new boolean[numbers.length()];
        for (int i = 0 ; i < numbers.length() ; i++) {
            String temp = "";
            temp += numbers.charAt(i);
            visited[i] = true;
            
            back(numbers, temp, visited);
            
            visited[i] = false;
            
        }
        
        for (Integer i : set) {
            boolean sosu = true;
            if (i.equals(1) || i.equals(0)) {
                continue;
            }
            for (int j = 2 ; j < i ; j++) {
                if (i % j == 0) {
                    sosu = false;
                }
            }
            if (sosu) {
                answer += 1;
            }
        }
        
        return answer;
    }
    
    public void back(String numbers, String str, boolean[] visited) {
        set.add(Integer.parseInt(str));
        for (int i = 0 ; i < numbers.length() ; i++) {
            String temp = str;
            if (visited[i] == false) {
                temp += numbers.charAt(i);
            
                visited[i] = true;
                back(numbers, temp, visited);
                visited[i] = false;
            }
        }
    }
}