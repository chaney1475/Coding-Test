import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int N = arrayA.length;
        
        int answer = 0;
        
        int a = arrayA[0];
        
        for (int i = 1; i < N; i++){
            a = gcd(arrayA[i], a);
            if (a == 1) break;
        }
        
        int b = arrayB[0];
        
        for (int i = 1; i < N; i++){
            b = gcd(arrayB[i],b);
            if (b == 1) break;
        }
        
        
        if(!canDivide(arrayB, a)){
            answer = Math.max(answer, a);
        }
        
        if(!canDivide(arrayA, b)){
            answer = Math.max(answer, b);
        }
        
        
        return answer;
    }
    
    int gcd(int a, int b){
        
        int tmp = -1;
        
        if (b > a){
            tmp = a;
            a = b;
            b = tmp;
        }
        
        while (b != 0){
            tmp = b;
            b = a % b;
            a = tmp;
        }
        
        return a;
    }
    
    boolean canDivide(int[] array, int gcd){
        for(int num:array){
            if(num%gcd==0){
                return true;
            }
        }
        return false;
    }
    
}