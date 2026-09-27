import java.util.*;
class Solution {
    public int solution(int distance, int[] rock, int n) {
        int answer = 0;
        int[] rocks = new int[rock.length + 1];
        long left = 1;
        long right = distance;
        for (int i = 0 ; i < rock.length ; i++) {
            rocks[i] = rock[i];
        }
        rocks[rock.length] = distance;
        Arrays.sort(rocks);
        while (left <= right) {
            int result = distance;
            long mid = left + (right - left) / 2;
            int removeCount = 0;
            int p = 0;
            for (int i = 0 ; i < rocks.length ;i++) {
                if (rocks[i] - p < mid) {
                    removeCount += 1;
                } else {
                    result = result > rocks[i] - p ? rocks[i] - p : result;
                    p = rocks[i];
                }
                if (removeCount > n) {
                    right = mid - 1;
                    break;
                }
            }
            if (removeCount <= n) {
                left = mid + 1;
                answer = result;
            }
        }
        
        return answer;
    }
}