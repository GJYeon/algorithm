class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for (int i = 1 ; i <= s.length()/2 ; i++) {
            String temp = "";
            String answerTemp = "";
            int p = 0;
            while (p < s.length()) {
                if (s.length() -1  - p < i) {
                    answerTemp += s.substring(p);
                    break;
                }
                temp = s.substring(p, p + i);
                int cnt = 1;
                
                p += i;

                while (p + i <= s.length()
                        && s.substring(p, p + i).equals(temp)) {

                    cnt++;
                    p += i;
                }

                if (cnt > 1) {
                    answerTemp += cnt + temp;
                } else {
                    answerTemp += temp;
                }
                
            }
            
            
            answer = answer > answerTemp.length() ? answerTemp.length() : answer;
        }
        return answer;
    }
}