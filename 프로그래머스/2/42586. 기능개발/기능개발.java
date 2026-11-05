import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
     
        List<Integer> list = new ArrayList<>();
        
        int idx = 0;
        while (idx < progresses.length) {
            int alpha = 100 - progresses[idx];
            int cnt = alpha % speeds[idx] == 0 ? alpha / speeds[idx] : alpha / speeds[idx] + 1;
            int m = 1;
            boolean check = true;
            for (int i = idx + 1 ; i < progresses.length ; i++ ) {
                progresses[i] += cnt * speeds[i];
                if (check == true && progresses[i] >= 100) {
                    m++;
                } else {
                    check = false;
                }
            }
            idx += m;
            list.add(m);
        }
        int[] answer = new int[list.size()];
        for (int i = 0 ; i < list.size() ; i++) {
            answer[i] = list.get(i);
        }
         
        return answer;
    }
}