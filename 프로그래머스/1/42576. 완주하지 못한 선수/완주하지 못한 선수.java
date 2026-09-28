import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String c : completion) {
            if (map.get(c) != null) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);   
            }
        }
        
        for (String p : participant) {
            if (map.get(p) != null) {
                if (map.get(p) == 1) {
                    map.remove(p);
                } else {
                    map.put(p, map.get(p) - 1);
                }
                continue;
            } else {
                answer = p;
                break;
            }
        }
        
        return answer;
    }
}