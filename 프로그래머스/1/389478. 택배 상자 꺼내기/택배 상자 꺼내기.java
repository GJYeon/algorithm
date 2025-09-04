class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int x,y,a;
        if (n%w == 0){
            x = n / w;
            y = (num%w == 0) ? num/w : (num/w+1); 
            answer = x - y +1;
        } else {
            if (((n-1)/w%2) == ((num-1)/w%2)) {
                answer = (n - num) /w + 1;
            } else {
                x = w - ((num-1)%w);
                y = (n-1) % w +2;
                a = (num-1) / w + 1;
                if (y >= x) {answer = (n/w+1) - a + 1;}
                else {answer = (n-1)/w - a + 1;}
                
            }
        }
        return answer;
    }
}