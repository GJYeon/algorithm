import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0 ; i < participant.length ; i++) {
            if (map.get(participant[i]) == null) {
                map.put(participant[i], 1);
            } else {
                map.put(participant[i], map.get(participant[i]) + 1);
            }
        }
        
        for (int i = 0 ; i < completion.length ; i++) {
            if (map.get(completion[i]) == 1) {
                map.remove(completion[i]);
            } else {
                map.put(completion[i], map.get(completion[i]) - 1);
            }
        }
        
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        for (Map.Entry<String, Integer> entry : entryList) {
            answer = entry.getKey();
        }
        
        return answer;
    }
}