import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (Integer i : works) {
            pq.add(i);
        }
        
        for (int i = 0 ; i < n ; i++) {
            if (pq.isEmpty()) {
                return 0;
            }
            Integer t = pq.poll();
            if (t == 1) {
                continue;
            }
            pq.add(t-1);
        }
        
        while (!pq.isEmpty()) {
            Integer t = pq.poll();
            answer += t*t;
        }
        
        return answer;
    }
}