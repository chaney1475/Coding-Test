import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        int N = people.length;
        
        Arrays.sort(people);
        
        int ans = 0;
        int s = 0;
        int e = N - 1;
        
        while (s < e){
            if (people[s] + people[e] > limit){
                e--;
            }else{
                ans++;
                s++;
                e--;
            }
        }
        return N - (ans * 2) + ans;
        
    }
}