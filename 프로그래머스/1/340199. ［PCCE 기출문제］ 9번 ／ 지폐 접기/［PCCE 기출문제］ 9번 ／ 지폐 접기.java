class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while(true) {
            int max = (bill[0] > bill[1]) ? bill[0] : bill[1];
            int min = (bill[0] < bill[1]) ? bill[0] : bill[1];
            if ((max<=wallet[0]&&min<=wallet[1])||(max<=wallet[1]&&min<=wallet[0])) {
                break;
            } else {
                max /= 2;
                bill[0] = max;
                bill[1] = min;
                answer += 1;
            }
        }
        return answer;
    }
}