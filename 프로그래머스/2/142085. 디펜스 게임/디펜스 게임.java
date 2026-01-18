import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int cnt = 0;
        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0 ; i < enemy.length ; i++) {
            cnt += enemy[i];
            pq.offer(enemy[i]);
            
            while (n < cnt) {
                if (k > 0) {
                    cnt -= pq.poll();
                    k -= 1;
                } else {
                    answer = i;
                    return answer;
                }
            }
        }
        if (answer == 0) {
            answer = enemy.length;   
        }
        return answer;
    }
}