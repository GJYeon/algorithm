import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Integer[] d_Integer = new Integer[d.length];
        for (int i = 0 ; i < d.length ; i++) {
            d_Integer[i] = d[i];
        }
        
        Arrays.sort(d_Integer);
        
        for (int i = 0 ; i < d_Integer.length ; i++) {
            if (budget - d_Integer[i] >= 0) {
                answer += 1;
                budget = budget - d_Integer[i];
            } else {
                break;
            }
        }
        
        return answer;
    }
}