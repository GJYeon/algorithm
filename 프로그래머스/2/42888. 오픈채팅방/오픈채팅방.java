import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (int i = 0 ; i < record.length ; i++) {
            String[] input = record[i].split(" ");
            if (input[0].equals("Enter")) {
                map.put(input[1], input[2]);
            } else if (input[0].equals("Leave")) {
                continue;
            } else {
                map.put(input[1], input[2]);
            }
            
        }
        
        for (int i = 0 ; i < record.length ; i++) {
            String[] input = record[i].split(" ");
            String str = "";
            if (input[0].equals("Enter")) {
                str = map.get(input[1]) + "님이 들어왔습니다.";
                answer.add(str);
            } else if (input[0].equals("Leave")) {
                str = map.get(input[1]) + "님이 나갔습니다.";
                answer.add(str);
            } else {
                continue;
            }
            
        }
        
        
        return answer.toArray(new String[0]);
    }
}