import java.util.*;

class Solution {
    static int[] rep;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        rep = new int[n];
        
        for (int i = 0; i < n; i++){
            rep[i] = i;
        }
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (computers[i][j] == 1){
                    friend(i,j);
                }
            }
        }
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < n; i++){
            set.add(find(i));
        }
        
        return set.size();
    }
    
    static boolean friend(int a, int b){
        a = find(a);
        b = find(b);
        
        if (a == b) return false;
        
        if(a < b) rep[b] = a;
        else rep[a] = b;
        
        return true;
    }
    
    static int find(int x){
        if(x != rep[x]){
            rep[x] = find(rep[x]);
        }
        return rep[x];
    }
}