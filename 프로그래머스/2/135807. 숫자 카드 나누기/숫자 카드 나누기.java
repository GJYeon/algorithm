import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int x = arrayA[0];
        for (int i = 0 ; i < arrayA.length ; i++) {
            x = gcd(x, arrayA[i]);
            if (x == 1) {
                break;
            }
        }
        
        for (int i = 0 ; i < arrayB.length ; i++) {
            if (arrayB[i]%x==0) {
                x = 1;
                break;
            }
            
        }
        
        int y = arrayB[0];
        for (int i = 0 ; i < arrayB.length ; i++) {
            y = gcd(y, arrayB[i]);
            if (y == 1) {
                break;
            }
        }
        
        for (int i = 0 ; i < arrayA.length ; i++) {
            if (arrayA[i]%y==0) {
                y =1;
                break;
            }
            
        }
        answer = x > y ? x : y;
        if (answer == 1) answer = 0;
        return answer;
    }
    
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b , a%b);
    }
}