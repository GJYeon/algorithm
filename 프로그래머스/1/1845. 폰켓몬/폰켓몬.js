function solution(nums) {
    var answer = 0;
    
    const set = new Set();
    for (let i = 0; i < nums.length ; i++) {
        set.add(nums[i]);
    }
    
    answer = set.size >= nums.length/2 ? nums.length/2 : set.size;
    
    return answer;
}