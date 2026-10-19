import java.util.*;
class Solution {
    public int solution(int[] citation) {
        int answer = 0;
        Integer[] citations = new Integer[citation.length];
        for (int i = 0 ; i < citation.length ;i++) {
            citations[i] = citation[i];
        }
        Arrays.sort(citations, Collections.reverseOrder());
        
        for (int i = 0 ; i <= 10000 ; i++) {
            int cnt = 0;
            for (int j = 0 ; j <citations.length ; j++) {
                if (citations[j] >= i) {
                    cnt += 1;
                } else {
                    break;
                }
            }
            if (cnt >= i) {
                answer = Math.max(i, answer);
            } else {
                break;
            }
        }
        
        return answer;
    }
}