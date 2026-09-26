import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i : scoville) {
            pq.add(i);
        }
        
        while (true) {
            if (pq.peek() >= K) {
                break;
            } else {
                if (pq.size() == 1) {
                    return -1;
                }
                Integer newo = pq.poll() + pq.poll() * 2;
                pq.add(newo);
                answer += 1;
            }
        }
        
        return answer;
    }
}