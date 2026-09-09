import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> target = new ArrayList<>();
        Map<String, Integer> termsMap = new HashMap<>();
        String[] todayYMD = today.split("\\.");
        Integer todayYear = Integer.parseInt(todayYMD[0]);
        Integer todayMonth = Integer.parseInt(todayYMD[1]);
        Integer todayDay = Integer.parseInt(todayYMD[2]);
        
        for (int i = 0 ; i < terms.length ; i++) {
            String[] termsToList = terms[i].split(" ");
            String key = termsToList[0];
            Integer value = Integer.parseInt(termsToList[1]);
            termsMap.put(key, value);
        }
        
        for (int i = 0 ; i < privacies.length ; i++) {
            String[] privacy = privacies[i].split(" ");
            String key = privacy[1];
            
            String time = privacy[0];
            String[] YMD = time.split("\\.");
            int year = Integer.parseInt(YMD[0]);
            int month = Integer.parseInt(YMD[1]);
            int day = Integer.parseInt(YMD[2]);
            
            int term = termsMap.get(key);
            int termMonth = term % 12;
            int termYear = term / 12;
            
            if (day == 1) {
                month = month + termMonth - 1;
                day = 28;
                year += termYear;
                if (month > 12) {
                    month -= 12;
                    year += 1;
                }
            } else {
                day = day - 1;
                month = month + termMonth;
                year += termYear;
                if (month > 12) {
                    month -= 12;
                    year += 1;
                } 
            }
            
            if (year < todayYear) {
                target.add(i);
            } else if (year == todayYear && month < todayMonth) {
                target.add(i);
            } else if (year == todayYear && month == todayMonth && day < todayDay) {
                target.add(i);
            }
            
            
        }
        int[] answer = new int[target.size()];
        for (int i = 0 ; i < target.size() ; i++) {
            answer[i] = target.get(i) + 1;
        }
        return answer;
    }
}