import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        Set<Integer>[] sets = new HashSet[9];
        
        for (int i = 1; i <= 8; i++) {
            sets[i] = new HashSet<>();
        }
        
        sets[1].add(N);
        if (N == number) return 1;
        
        for (int i = 2; i <= 8; i++) {
            
            // 이어붙이기
            sets[i].add(makeNum(i, N));
            
            for (int j = 1; j < i; j ++) {
                for (int n1 : sets[j]) {
                    for (int n2 : sets[i - j]) {
                        
                        sets[i].add(n1 + n2);
                        sets[i].add(n1 * n2);
                        if (n1 - n2 > 0) {
                        sets[i].add(n1 - n2);
                        }
                        if (n2 - n1 > 0) {
                        sets[i].add(n2 - n1);
                        }
                        
                        if (n2 != 0) sets[i].add(n1 / n2);
                        if (n1 != 0) sets[i].add(n2 / n1);
                    }
                }
            }

            if (sets[i].contains(number)) return i;   
        }
        
        return -1;
    }
    
    public int makeNum(int n, int num) {
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp = tmp * 10 + num;
        }
        return tmp;
    }
}