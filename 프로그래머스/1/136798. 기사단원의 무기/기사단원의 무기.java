
import java.util.*;
class Solution {
    static int[] sum;
    static boolean[] isPalin;
    static int N;
    public int solution(int n, int limit, int power) {
        int answer = 0;
        N = n;
        isPalin = new boolean[N+1];
        
        // 각 숫자의 공격력 구하자
        sum = new int[N + 1];
        init();
        
        int total = 0;
        int left = 0;
        
        for (int i = 1; i <= N; i++){
            int s = 0;
            
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    if (j == i / j) s++;
                    else s += 2;
                }
            }
            
            if(s > limit) total += power;
            else total += s;
            
        }
        
        // System.out.println(Arrays.toString(sum));
        
        return total;
    }
    
    void init(){
        for (int i = 2; i <= N; i++){
            if(isPalin[i]) continue;
            for (int j = i + i; j <= N; j+= i){
                isPalin[j] = true;
                // System.out.println(j);
            }
        }
        // System.out.println(Arrays.toString(isPalin));
    }
    
}