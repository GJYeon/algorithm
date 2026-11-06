import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> reported = new HashMap<>();
        
        for (int i = 0 ; i < id_list.length ; i++) {
            reportMap.put(id_list[i], new HashSet<>());
            reported.put(id_list[i], 0);
        }
        for (int i = 0 ; i <report.length ; i++) {
            String[] oneReport = report[i].split(" ");
            String reporting = oneReport[0];
            String reportedP = oneReport[1];
            
            if (reportMap.get(reporting).contains(reportedP)) {
                continue;
            } else {
                reportMap.get(reporting).add(reportedP);
                reported.put(reportedP, reported.get(reportedP) + 1);
            }
        }
        
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(reported.entrySet());
        List<Map.Entry<String, Set<String>>> reportList = new ArrayList<>(reportMap.entrySet());
        
        Map<String, Integer> answerMap = new HashMap<>();
        for (int i = 0 ; i < id_list.length ; i++) {
            answerMap.put(id_list[i], 0);
        }
        
        for (Map.Entry<String, Integer> entry : entryList) {
            String kk = entry.getKey();
            Integer v = entry.getValue();
            
            if (v >= k) {
                for (Map.Entry<String, Set<String>> reportEntry : reportList) {
                    if (reportEntry.getValue().contains(kk)) {
                        answerMap.put(reportEntry.getKey(), answerMap.get(reportEntry.getKey()) + 1);
                    }
                }
            }
        }

        for (int i = 0 ; i < id_list.length ; i++) {
            String s = id_list[i];
            answer[i] = answerMap.get(id_list[i]);
        }
        
        
        
        
        return answer;
    }
}