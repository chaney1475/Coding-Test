import java.util.*;

class Solution {
    public int solution(int a, int b, int n) {
        
        int answer = 0;
        
        while( n >= a) {
            int mod = n / a;
            int left = n % a;
            
            answer+= mod * b;
            n = mod * b + left;
        }
        
        return answer;
    }
}