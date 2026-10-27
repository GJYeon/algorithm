import java.util.*;
class Solution {
    public int solution(int[] C, int[] D) {
        int answer = 0;
        Integer[] A = new Integer[C.length];
        Integer[] B = new Integer[D.length];
        
        for (int i = 0 ; i < A.length ; i++) {
            A[i] = C[i];
            B[i] = D[i];
        }
        
        Arrays.sort(A, Collections.reverseOrder());
        Arrays.sort(B, Collections.reverseOrder());
        
        int start = 0;
        int end = B.length - 1;
        
        for (int i = 0 ; i < A.length ; i++) {
            if (A[i] < B[start]) {
                answer += 1;
                start += 1;
            } else {
                end -= 1;
            }
        }
        
        
        return answer;
    }
}