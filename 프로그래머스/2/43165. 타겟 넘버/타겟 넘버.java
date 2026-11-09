class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        
        
        check(numbers, target, 1, numbers[0]);
        check(numbers, target, 1, -numbers[0]);
        
        return answer;
    }
    
    public void check(int[] numbers, int target, int idx, int temp) {
        if (idx == numbers.length) {
            if (target == temp) {
                answer += 1;
            }
            return;
        }
        check(numbers, target, idx + 1, temp + numbers[idx]);
        check(numbers, target, idx + 1, temp - numbers[idx]);
    }
}