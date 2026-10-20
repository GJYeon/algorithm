import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int i = 1 ; i <= yellow ; i++ ) {
            if (yellow % i == 0) {
                int k = yellow / i;
                int w = Math.max(i, k);
                int h = Math.min(i, k);
                
                if (brown == (2*w + 2*h + 4)) {
                    answer[0] = w + 2;
                    answer[1] = h + 2;
                }
            }
        }
        
        return answer;
    }
}