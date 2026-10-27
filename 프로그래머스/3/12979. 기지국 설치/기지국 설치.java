import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int idx = 0;
        int camp = 1;
        while (camp <= n && idx < stations.length) {
            if (camp < stations[idx] - w) {
                int len = stations[idx] - w - camp;
                int width = 2 * w + 1;
                int cnt = len % width == 0 ? len / width : len / width + 1;
                answer += cnt;
                camp = stations[idx] + w + 1;
                idx += 1;
            } else {
                camp = camp = stations[idx] + w + 1;
                idx += 1;
            }
        }
        
        if (camp <= n) {
            int len = n + 1 - camp;
            int width = 2 * w + 1;
            int cnt = len % width == 0 ? len / width : len / width + 1;
            answer += cnt;
        }

        return answer;
    }
}