class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int server = 0;
        int count = 0;
        int[] openServers = new int[24];
        for (int i = 0; i < 24 ; i++) {
            if (i>=k){
                if (openServers[i-k] > 0) {
                    server = server - openServers[i-k];
                }
            }
            int permited = (server + 1) * m - 1;
            if (permited < players[i]) {
                int over = players[i] - permited;
                int plusCount = 0;
                if (over % m != 0) {
                    plusCount = over/m +1;
                } else {
                    plusCount = over/m;
                }
                count += plusCount;
                server += plusCount;
                openServers[i] = plusCount;
                
            }
        }
        answer = count;
        return answer;
    }
}