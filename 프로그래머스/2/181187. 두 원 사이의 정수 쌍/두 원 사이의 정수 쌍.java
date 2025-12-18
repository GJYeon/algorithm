class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        /*for (int i = 1; i <= r2 ; i++) {
            int t = Math.sqrt(Math.pow(r1,2) - Math.pow(i,2)) % 1 > 0 ? (int) Math.sqrt(Math.pow(r1,2) - Math.pow(i,2)) + 1 : (int) Math.sqrt(Math.pow(r1,2) - Math.pow(i,2)) ;
            int k = (int) Math.sqrt(Math.pow(r2,2) - Math.pow(i,2));
            for (int j = t ; j <= k ; j++){
                if (Math.pow(i,2) + Math.pow(j,2) >= Math.pow(r1,2) && Math.pow(i,2) + Math.pow(j,2) <= Math.pow(r2,2)){
                    answer += 1;
                }
            }
        }
        */
        for (int i = 1 ; i <= r2 ; i++) {
            if (i < r1){
                answer += Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2))) - Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2))) + 1;
            } else {
                answer += Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2))) + 1;
            }
        }
        
        return answer*4;
    }
}