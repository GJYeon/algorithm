import java.util.*;
class Solution {
    
    public int solution(String word) {
        int answer = 0;
        String aeiou = "AEIOU";
        int cnt = 0;
        List<String> list = new ArrayList<>();
        loop(aeiou, "", cnt, list);
        list.sort(null);
        
        for (int i = 0 ; i < list.size() ; i++) {
            if (word.equals(list.get(i))) {
                answer = i+1;
                break;
            }
        }
            
        
        return answer;
    }
    
    public void loop(String aeiou, String str, int cnt, List<String> list) {
        cnt++;
        for (int i = 0 ; i < 5 ; i++) {
            list.add(str + aeiou.charAt(i));
            if (cnt <= 4) {
                loop(aeiou, str + aeiou.charAt(i), cnt, list);
            }
        }
    }
}