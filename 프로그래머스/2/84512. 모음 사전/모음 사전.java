import java.util.*;
class Solution {
    public int solution(String word) {
        int answer = 0;
        char[] c = {'A', 'E', 'I', 'O', 'U'};
        List<String> dictionary = new ArrayList<>();
        for (int i = 0 ; i < 5 ; i++) {
            int cnt = 1;
            String str = "" + c[i];
            dictionary.add(str);
            check(c, dictionary, str, cnt);
        }
        
        dictionary.sort(null);
        for (int i = 0 ; i < dictionary.size() ; i++) {
            if (dictionary.get(i).equals(word)) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }
    
    public void check(char[] c, List<String> dictionary, String str, int cnt) {
        cnt += 1;
        for (int i = 0 ; i < 5 ; i++) {
            String temp = str + c[i];
            dictionary.add(temp);
            if (cnt < 5) {
                check(c,dictionary, temp, cnt);
            }
        }
    }
}