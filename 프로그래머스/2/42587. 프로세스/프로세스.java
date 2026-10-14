import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<List<Integer>> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length ; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            list.add(priorities[i]);
            queue.add(list);
            pq.add(priorities[i]);
        }
        
        while (!pq.isEmpty()) {
            int priority = pq.poll();
            answer += 1;
            for (int i = 0 ; i < queue.size() ; i++) {
                if (priority == queue.peek().get(1)) {
                    List<Integer> list = queue.poll();
                    if (list.get(0).equals(location)) {
                        return answer;
                    } else {
                        break;
                    }
                } else {
                    List<Integer> list = queue.poll();
                    queue.add(list);
                }
            }
        }
        return answer;
    }
}