import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int min = gems.length + 1;
        Set<String> set = new HashSet<>();
        for (int i = 0 ; i < gems.length ; i++) {
            set.add(gems[i]);
        }
        int variety = set.size();
        
        Map<String, Integer> map = new HashMap<>();
        for (String s : set) {
            map.put(s, 0);
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> cntSet = new HashSet<>();
        int idx = 0;
        for (int i = 0 ; i < gems.length ; i++) {
            queue.add(gems[i]);
            if (map.get(gems[i]) == 0) {
                cntSet.add(gems[i]);
                map.put(gems[i], 1);
            } else {
                map.put(gems[i], map.get(gems[i])+1);
            }
            
            while (cntSet.size() == set.size()) {
                if (min > i - idx + 1) {
                    min = i - idx + 1;
                    answer[0] = idx + 1;
                    answer[1] = i + 1;
                }
                
                String bosuk = queue.poll();
                idx++;
                map.put(bosuk, map.get(bosuk) - 1);
                if (map.get(bosuk) == 0) {
                    cntSet.remove(bosuk);
                }
                
                
            }
        }
        
        return answer;
    }
}