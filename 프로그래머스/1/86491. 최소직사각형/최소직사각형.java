import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        Integer[] width = new Integer[sizes.length];
        Integer[] height = new Integer[sizes.length];
        
        for (int i = 0 ; i < sizes.length ;i++) {
            Integer M = sizes[i][0] > sizes[i][1] ? sizes[i][0] : sizes[i][1];
            Integer m = sizes[i][0] <= sizes[i][1] ? sizes[i][0] : sizes[i][1];
            
            width[i] = M;
            height[i] = m;
        }
        
        Arrays.sort(width, Collections.reverseOrder());
        Arrays.sort(height, Collections.reverseOrder());
        
        answer = width[0] * height[0];
        
        return answer;
    }
}