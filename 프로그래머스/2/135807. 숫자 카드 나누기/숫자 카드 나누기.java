import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        answer = Math.max(findMax(arrayA, arrayB), findMax(arrayB, arrayA));
        return answer;
    }
    public int findMax(int[] A, int[] B) {
        
        int g = A[0];
        for (int a: A) {
            g = gcd(a,g);
        }
        
        for (int b: B) {
            if (b % g == 0) {
                return 0;
            }
        }
        return g;
    }
    
    public int gcd (int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}