import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for (int i = 1 ; i <= s.length()/2 ; i++) {
            int idx = i;
            String temp = "";
            String pre_temp = s.substring(0,idx);
            Integer n = 1;
            boolean check = false;
            int len = pre_temp.length();
            while (s.length() - idx >= i) {
                temp = s.substring(idx, idx + i);
                if (temp.equals(pre_temp)) {
                    n += 1;
                } else {
                    if (n == 1) {
                        len += temp.length();
                    } else {
                        len = len + temp.length() + String.valueOf(n).length();
                    }
                    n = 1;
                }
                idx += i;
                pre_temp = temp;
                
            }
            
            
            if (s.length() - idx > 0) {
                len += s.length() - idx;
                
                
            }
            if (n == 1) {
                //len += temp.length();
            } else {
                len = len + String.valueOf(n).length();
            }
            
            answer = Math.min(answer, len);
        }
        
        return answer;
    }
}