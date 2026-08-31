class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        for (int i = 0 ; i < nums.length - 2 ; i++) {
            for (int j = i+1 ; j < nums.length-1 ; j++) {
                for (int k = j + 1 ; k <nums.length ; k++) {
                    int target = nums[i] + nums[j] + nums[k];
                    int count = 1;
                    for (int p = 2 ; p < target ; p++) {
                        if (target % p == 0) {
                            count = 0;
                            break;
                        }
                    }
                    answer += count;
                }
            }
        }
        

        return answer;
    }
}