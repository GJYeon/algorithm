import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer2 = new ArrayList<>();
        boolean[] visited = new boolean[progresses.length];
        int pivot = 0;
        while (pivot < progresses.length) {
            int cnt = (100 - progresses[pivot]) % speeds[pivot] != 0 ? 
                (100 - progresses[pivot]) / speeds[pivot] + 1 : 
            (100 - progresses[pivot]) / speeds[pivot];
            int c = 0;
            boolean check = true;
            for (int i = pivot ; i < progresses.length ; i++) {
                progresses[i] += speeds[i] * cnt;
                if (progresses[i] >= 100 && visited[i] == false) {
                    if (check) {
                        c += 1; 
                        visited[i] = true;
                    }
                  
                } else {
                    if (progresses[i] < 100) {
                        check = false;
                    }
                }
            }
            pivot += c;
            answer2.add(c);
            
        }
        int[] answer = new int[answer2.size()];
        for (int i = 0; i < answer2.size(); i++) {
            answer[i] = answer2.get(i);
        }
        
        return answer;
    }
}