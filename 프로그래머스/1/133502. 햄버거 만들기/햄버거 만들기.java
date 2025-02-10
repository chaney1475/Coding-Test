import java.util.*;
class Solution {
    public int solution(int[] ingre) {
        
        ArrayList<Integer> list = new ArrayList<>();
        int N = ingre.length;
        
        for (int i = 0; i < N; i++){
            list.add(ingre[i]);
        }
        
        int cnt = 0;
        
        int i = 0; 
        int k = ingre.length - 3;
        
        while( i < k){
            if (list.get(i) == 1 && list.get(i+1) == 2 &&
               list.get(i+2) == 3 && list.get(i+3) == 1)
            {
                list.remove(i+3);
                list.remove(i+2);
                list.remove(i+1);
                list.remove(i);
                k -= 4;
                if(i-4 >= -1) i -= 4;
                else i = -1;
                cnt++;
            }
            i++;
        }
        
        return cnt;
        
    }
    
}