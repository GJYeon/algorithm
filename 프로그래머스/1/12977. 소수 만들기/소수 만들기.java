import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0 ; i < nums.length - 2 ; i++) {
            for (int j = i+1 ; j < nums.length - 1 ; j++) {
                for (int k  = j + 1 ; k < nums.length ; k++) {
                    int num = nums[i]+nums[j]+nums[k];
                    boolean check = true;
                    for (int n = 2 ; n < num ; n++) {
                        if (num % n == 0) {
                            check = false;
                            break;
                        }
                    }
                    if (check == true) {
                        answer += 1;
                    }
                }
            }
        }

        return answer;
    }
}