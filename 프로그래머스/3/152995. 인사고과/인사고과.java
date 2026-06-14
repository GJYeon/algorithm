import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int[] wan = new int[2];
        wan[0] = scores[0][0];
        wan[1] = scores[0][1];
        
        int rank = 1;
        
        Arrays.sort(scores, (a,b)->{
            if (a[0] == b[0]) return a[1] - b[1];
            else return b[0] - a[0];
        });
        
        int max = 0;
        
        for (int i = 0 ; i < scores.length ; i++) {
            if (scores[i][1] < max) {
                if (scores[i][0] == wan[0] && scores[i][1] == wan[1]) {
                    return -1;
                }
            } else {
                max = scores[i][1];
                if (scores[i][0] + scores[i][1] > wan[0] + wan[1]) {
                    rank++;
                    
                                                                   }
            }
        }
        answer = rank;
        return answer;
    }
}