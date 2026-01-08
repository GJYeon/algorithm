class Solution {
    public int solution(int storey) {
        int answer = 0;
        String str = Integer.toString(storey);
        int strLength = str.length();
        int x = 0;
        for (int i = 0 ; i < strLength ; i++) {
            int n = (str.charAt(i) - '0');
            n = n + x;
            if (n == 10) {
                x = 1;
                continue;
            }
            if (n > 5) {
                
                answer += (10 - n);
                x = 1;
            } else if (n < 5) {
                answer += n;
                x = 0;
            } else {
                if (i == strLength-1) {
                    answer += n;
                    x = 0;
                } else {
                    if ((str.charAt(i+1)-'0') >= 5) {
                        answer += (10 - n);
                        x = 1;
                    } else {
                        answer += n;
                        x = 0;
                    }
                }
            }
        }
        answer += x;
        
        
        return answer;
    }
    
    
}
