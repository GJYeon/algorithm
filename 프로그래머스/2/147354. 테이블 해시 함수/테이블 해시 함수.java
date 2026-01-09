import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int rowLength = data.length;
        int colLength = data[0].length;
        int[][] sortedData = new int[rowLength][colLength];
        int[] S = new int[rowLength];
        
        Arrays.sort(data, new Comparator<int[]>() { 
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[col-1]!=o2[col-1] ? o1[col-1]-o2[col-1] : o2[0]-o1[0]; 
            }
        });
        
        
        for (int i = 0 ; i < rowLength ; i++) {
            int S_i = 0;
            for (int j = 0 ; j < colLength ; j++) {
                S_i += data[i][j] % (i+1);
            }
            S[i] = S_i;
            //answer ^= S_i;
        }
        
        for (int i = row_begin-1 ; i <= row_end-1 ; i++) {
            answer ^= S[i];
        }
        
        
        return answer;
    }
}

