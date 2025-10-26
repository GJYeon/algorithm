class Solution {
    int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        
        dfs(new int[5], 0, 1, n, q, ans);
        return answer;
    }
    
    void dfs(int[] picked, int depth, int start, int n, int[][] q, int[] ans) {
        if (depth == 5) {
            if (checked(picked, q , ans)) answer++;
            return;
        }
        
        for (int i = start ; i <= n ; i++) {
            picked[depth] = i;
            dfs(picked, depth+1, i+1, n, q, ans);
        }
    }
    
    boolean checked(int[] picked, int[][] q, int[] ans) {
        for (int i = 0; i < q.length ; i++){
            int cnt = 0;
            
            for (int a : picked) {
                for (int b : q[i]) {
                    if (a == b) cnt++;
                }
            }
            if (cnt != ans[i]) return false;
        }
        return true;
    }
}