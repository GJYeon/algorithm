import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        boolean isAllDiscount = false;
        
        for (int i = 0 ; i < discount.length ; i++) {
            if (queue.size() != 10) {
                queue.add(discount[i]);
                if (Arrays.asList(want).contains(discount[i])) {
                    int idx = Arrays.asList(want).indexOf(discount[i]);
                    number[idx] -= 1;
                    for (int j = 0; j < number.length ; j++) {
                        if (number[j] != 0) {
                            isAllDiscount = false;
                            break;
                        }
                        isAllDiscount = true;
                    }
                    if (isAllDiscount) {
                        answer += 1;
                        isAllDiscount = false;
                    }
                }
            } else {
                String fruit = queue.poll();
                if (Arrays.asList(want).contains(fruit)) {
                    int idx = Arrays.asList(want).indexOf(fruit);
                    number[idx]++;
                }
                queue.add(discount[i]);
                if (Arrays.asList(want).contains(discount[i])) {
                    int idx = Arrays.asList(want).indexOf(discount[i]);
                    number[idx]--;
                    for (int j = 0; j < number.length ; j++) {
                        if (number[j] != 0) {
                            isAllDiscount = false;
                            break;
                        }
                        isAllDiscount = true;
                    }
                    if (isAllDiscount) {
                        answer += 1;
                        isAllDiscount = false;
                    }
                }
            }
        }
        
        return answer;
    }
}