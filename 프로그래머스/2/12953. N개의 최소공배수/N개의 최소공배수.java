import java.util.*;

/*
2의 최대 갯수
어떻게 볼건데?
1 * 3 * 4 * 7 * 2
= 12 * 14
*/

class Solution {
    public int solution(int[] arr) {
        
        int common = 1;
        int N = arr.length;
        
        int ans = arr[0];
        for (int i = 1; i < N; i++){
            int now = gcd(ans, arr[i]);
            ans = arr[i] / now * ans;
        }
        
        return ans;
        
        
    }
    int gcd(int a, int b){
        int tmp, n;
        
        if (a < b){
            tmp = b;
            b = a;
            a = tmp;
        }
        
        while( b != 0 ){
            n = a % b;
            a = b;
            b = n;
        }
        return a;
    }
    
}