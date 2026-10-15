import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int max = 0;
        int min = 1000000;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (String op : operations) {
            String[] parts = op.split(" ");
            String command = parts[0];
            int num = Integer.parseInt(parts[1]);
            
            if (command.equals("I")) {
                if (map.get(num) == null) {
                    map.put(num, 1);
                } else {
                    map.put(num, map.get(num) + 1);
                }
            } else if (command.equals("D")) {
                if (map.isEmpty()) {
                    continue;
                }
                if (num == 1) {
                    int maxKey = map.lastKey();
    
                    if (map.get(maxKey).equals(1)) {
                        map.remove(maxKey);
                    } else {
                        map.put(maxKey, map.get(maxKey) - 1);
                    }
                } else {
                    int minKey = map.firstKey();
    
                    if (map.get(minKey).equals(1)) {
                        map.remove(minKey);
                    } else {
                        map.put(minKey, map.get(minKey) - 1);
                    }
                }
            }
        }
        if (map.isEmpty()) {
            return answer;
        }
        answer[0] = map.lastKey();
        answer[1] = map.firstKey();
        return answer;
    }
}