import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        new_id = new_id.toLowerCase();
        
        String s = "";
        for (char c : new_id.toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.') {
                s += c;
            }
        }
        
        String s3 = "";
        s3 += s.charAt(0);
        for (int i = 1 ; i < s.length() ; i++) {
            if (s.charAt(i) == '.' && s.charAt(i-1) == '.') {
                continue;
            } else {
                s3 += s.charAt(i);
            }
        }
        
       
        while (s3.length() >0 && s3.charAt(0) == '.') {
            s3 = s3.substring(1);
        }
        while (s3.length() >0 && s3.charAt(s3.length()-1) == '.') {
            s3 = s3.substring(0, s3.length() -1);
        }
        
        if (s3.equals("")) {
            s3 += 'a';
        }
        
        if (s3.length() >= 16) {
            s3 = s3.substring(0, 15);
            while (s3.charAt(s3.length()-1) == '.') {
                s3 = s3.substring(0, s3.length() -1);
            }
        }
        
        if (s3.length() <= 2) {
            while (s3.length() != 3) {
                s3 += s3.charAt(s3.length()-1);
            }
        }
        
        answer = s3;
        
        return answer;
    }
}