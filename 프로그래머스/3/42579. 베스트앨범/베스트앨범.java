import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0 ; i < plays.length ; i++) {
            if (map.get(genres[i]) != null) {
                map.put(genres[i], map.get(genres[i]) + plays[i]);
            } else {
                map.put(genres[i], plays[i]);
            }
        }
        
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        
        entryList.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        
        Map<String, List<Integer[]>> map1 = new HashMap<>();
        for (int i = 0 ; i < plays.length ; i++) {
            if (map1.get(genres[i]) != null) {
                Integer[] temp = new Integer[2];
                temp[0]  = i;
                temp[1] = plays[i];
                map1.get(genres[i]).add(temp);
            } else {
                Integer[] temp = new Integer[2];
                temp[0]  = i;
                temp[1] = plays[i];

                List<Integer[]> list = new ArrayList<>();
                list.add(temp); 

                map1.put(genres[i], list); 
            }
        }
        
        List<Integer> r = new ArrayList<>();
        

        for (Map.Entry<String, Integer> entry : entryList) {
            List<Integer[]> list = map1.get(entry.getKey());
            if (list.size() == 1) {
                r.add(list.get(0)[0]);
            } else {
                list.sort((o1, o2) -> {
                    if (o1[1] != o2[1]) {
                        return o2[1].compareTo(o1[1]);
                    } else {
                        return o1[0].compareTo(o2[0]);
                    }
                });
                for (int i = 0 ; i < 2 ; i++) {
                    r.add(list.get(i)[0]);
                }
            }
        }
        int[] answer = new int [r.size()];
        for (int i = 0 ; i < r.size() ; i++) {
            answer[i] = r.get(i);
        }
        
        return answer;
    }
}