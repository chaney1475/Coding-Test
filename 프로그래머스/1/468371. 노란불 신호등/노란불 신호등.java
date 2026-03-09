import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        
        int limit = 1;
        
        for (int i = 0; i < n; i++) {
            int[] cur = signals[i];
            int total = cur[0] + cur[1] + cur[2];
            limit = lcm(limit, total);
        }
        
        for (int t = 1; t <= limit; t++) { 
            
            boolean allYellow = true;
            
            for (int[] s : signals) { 
                int G = s[0];
                int Y = s[1];
                int R = s[2];
            
                int cycle = G + Y + R;
                int pos = (t-1) % cycle;
            
                if (!(pos >= G && pos < G + Y)){
                    allYellow = false;
                    break;
                }
            
            }
            if (allYellow) return t;
        }
        return -1;
    }
    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    int lcm(int a, int b) {
        return a * b / (gcd(a,b));
    }
    
}