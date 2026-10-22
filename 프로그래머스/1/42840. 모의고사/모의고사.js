function solution(answers) {
    var answer = [];
    
    const one = [1,2,3,4,5];
    const two = [2,1,2,3,2,4,2,5];
    const three= [3,3,1,1,2,2,4,4,5,5];
    
    let cnt1 = 0;
    let cnt2 = 0;
    let cnt3 = 0;
    
    for (let i = 0 ; i < answers.length ; i++) {
        if (answers[i] === one[i%5]) {
            cnt1 = cnt1 + 1;
        }
        if (answers[i] === two[i%8]) {
            cnt2 = cnt2 + 1;
        }
        if (answers[i] === three[i%10]) {
            cnt3 = cnt3 + 1;
        }
    }
    
    let max = Math.max(cnt1, Math.max(cnt2, cnt3));
    
    if (cnt1 === max) {
        answer.push(1);
    }
    if (cnt2 === max) {
        answer.push(2);
    }
    if (cnt3 === max) {
        answer.push(3);
    }
    
    return answer;
}