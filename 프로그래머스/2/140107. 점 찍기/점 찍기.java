import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for (int i = 0 ; i*k <= d ; i++) {
            int yMax = (int) Math.floor(Math.sqrt(Math.pow(d ,2) - Math.pow(i*k , 2)));
            answer += yMax/k + 1;
        }
        return answer;
    }
}