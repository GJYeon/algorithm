import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> map = new HashMap<>();
        
        for (int i = 0 ; i < id_list.length ; i++) {
            map.put(id_list[i], new HashSet<>());
        }
        
        for (int i = 0 ; i < report.length ; i++) {
            String[] rp = report[i].split(" ");
            map.get(rp[0]).add(rp[1]);
        }
        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0 ; i < id_list.length ; i++) {
            cnt.put(id_list[i], 0);
        }
        
        
        for (int i = 0 ; i < id_list.length ; i++) {
            for (String reported : map.get(id_list[i])) {
                cnt.put(reported, cnt.get(reported) + 1);
            }
        }
        
        Set<String> bannedUsers = new HashSet<>();
        for (String id : id_list) {
            if (cnt.get(id) >= k) {
                bannedUsers.add(id);
            }
        }
        
        for (int i= 0 ; i < id_list.length; i++) {
            String id = id_list[i];
            int mailCount = 0;
            
            for (String reported : map.get(id)) {
                if (bannedUsers.contains(reported)) {
                    mailCount++;
                }
            }
            answer[i] = mailCount;
        }
        
        
        return answer;
    }
}