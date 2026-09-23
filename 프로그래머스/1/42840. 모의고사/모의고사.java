import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int cnt1 = 0;
        int max1 = 0;
        for (int i = 0 ; i < answers.length ; i++) {
            if (p1[cnt1%5] == answers[i]) {
                max1 += 1;
            }
            cnt1++;
        }
        
        int cnt2 = 0;
        int max2 = 0;
        for (int i = 0 ; i < answers.length ; i++) {
            if (p2[cnt2%8] == answers[i]) {
                max2 += 1;
            }
            cnt2++;
        }
        
        int cnt3 = 0;
        int max3 = 0;
        for (int i = 0 ; i < answers.length ; i++) {
            if (p3[cnt3%10] == answers[i]) {
                max3 += 1;
            }
            cnt3++;
        }
        
        map.put(1,max1);
        map.put(2,max2);
        map.put(3,max3);
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        
        int answerCnt = 1;
        if (entryList.get(0).getValue().equals(entryList.get(1).getValue())) {
            answerCnt += 1;
            if (entryList.get(1).getValue().equals(entryList.get(2).getValue())) {
                answerCnt += 1;
            }
        }
        int[] answer = new int[answerCnt];
        for (int i = 0 ; i < answerCnt ; i++) {
            answer[i] = entryList.get(i).getKey();
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}