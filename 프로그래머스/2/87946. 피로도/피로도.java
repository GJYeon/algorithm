class Solution {
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        boolean[] visited = new boolean[dungeons.length];
        backtrack(k, visited, dungeons, 0);
        
        for (int i = 0 ; i < dungeons.length ; i++) {
            
        }
        
        return max;
    }
    
    public void backtrack(int k, boolean[] visited, int[][] dungeons, int cnt) {
        if (max < cnt) {
            max = cnt;
        }
        for (int i = 0 ; i < dungeons.length ; i++) {
            if (visited[i] == false && k >= dungeons[i][0]) {
                visited[i] = true;
                backtrack(k - dungeons[i][1], visited, dungeons, cnt + 1);
                visited[i] = false;
            } 
        }
    }
}