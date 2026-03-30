import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        return Math.max(solve(arrayA, arrayB), solve(arrayB, arrayA));
    }
    
    public int solve(int[] A, int[] B) {
        int g = A[0];
        
        for (int i = 1; i < A.length; i++) {
            g = gcd(g, A[i]);
        }
        
        for (int b : B) {
            if (b % g == 0) return 0;
        }
        
        return g;
    }
    
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}