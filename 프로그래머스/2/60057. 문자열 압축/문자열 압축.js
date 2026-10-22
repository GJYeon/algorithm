function solution(s) {
    var answer = 0;
    let min = s.length;
    for (let i = 1 ; i <= s.length/2 ; i++) {
        let compressed = "";
        let prev = s.slice(0, i);
        let count = 1;
        
        for (let j = i ; j < s.length ; j+=i) {
            let current = s.slice(j, j+i);
            
            if (prev === current) {
                count++;
            } else {
                compressed += (count > 1 ? count + prev : prev);
                prev = current;
                count = 1;
            }
        }
        
        compressed += (count > 1 ? count + prev : prev);
        
        min = Math.min(min, compressed.length);
    }
    
    return min;
}