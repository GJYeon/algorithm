class Solution {
    int answer = -1;
    public int solution(int k, int[][] dungeons) {
        
        boolean[] visited = new boolean[dungeons.length];
        
        for (int i = 0 ; i < dungeons.length ; i++) {
            if (k >= dungeons[i][0]) {
                visited[i] = true;
                int hp = k - dungeons[i][1];
                int cnt = 1;
                answer = answer > cnt ? answer : cnt;
                back(hp, dungeons, visited, cnt);
                visited[i] = false;
            }
        }
        
        return answer;
    }
    
    public void back(int k, int[][] dungeons, boolean[] visited, int cnt) {
        for (int i = 0 ; i < dungeons.length ; i++) {
            if (k >= dungeons[i][0] && visited[i] == false) {
                visited[i] = true;
                int hp = k - dungeons[i][1];
                int tempCnt = cnt + 1;
                answer = answer > tempCnt ? answer : tempCnt;
                back(hp, dungeons, visited, tempCnt);
                visited[i] = false;
            }
        }
    }
}