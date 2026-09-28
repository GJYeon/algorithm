import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        
        for (int i = 0 ; i < answers.length ; i++) {
            if (one[i%5] == answers[i]) {
                sum1 += 1;
            }
            if (two[i%8] == answers[i]) {
                sum2 += 1;
            }
            if (three[i%10] == answers[i]) {
                sum3 += 1;
            }
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(1, sum1);
        map.put(2, sum2);
        map.put(3, sum3);
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        
        entryList.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        
        List<Integer> result = new ArrayList<>();
        
        result.add(entryList.get(0).getKey());
        if (entryList.get(0).getValue().equals(entryList.get(1).getValue())) {
            result.add(entryList.get(1).getKey());
            if (entryList.get(1).getValue().equals(entryList.get(2).getValue())) {
                result.add(entryList.get(2).getKey());
            }
        }
        result.sort(null);
        int[] answer = new int[result.size()];
        for (int i = 0 ; i < result.size() ; i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}