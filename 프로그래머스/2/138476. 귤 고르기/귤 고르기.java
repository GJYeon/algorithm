import java.util.Arrays;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        int[] list = new int[tangerine.length];
        int c = 0;
        list[c] = 1;
        for (int i = 1 ; i < tangerine.length ; i++) {
            if (tangerine[i] != tangerine[i-1]){
                c++;
                list[c] += 1;
            } else {
                list[c] += 1;
            }
        }
        Arrays.sort(list);
        for (int i = 0; i < list.length ; i++) {
            k -= list[list.length-1-i];
            if (k <= 0) {
                answer = i+1;
                break;
            }
            
        }
        return answer;
    }
}