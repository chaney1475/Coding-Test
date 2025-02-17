import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int answer = 0;
        
        int N = n;
        int[] have = new int[N + 1];
        Arrays.fill(have, 1);
        
        int len = lost.length;
        int len2 = reserve.length;
        
        for (int i = 0; i < len2; i++){
            have[reserve[i]]++;
        }
        for (int i = 0; i < len; i++){
            have[lost[i]]--;
        }
        
        // System.out.println(Arrays.toString(have));
        
        for (int i = 1; i <= N; i++){
            
            if (have[i] > 1 && i > 0 & have[i - 1] == 0){
                have[i]--;
                have[i-1]++;
            }
            if (have[i] > 1 && i + 1 <= N && have[i + 1] == 0){
                have[i]--;
                have[i + 1] ++;
            }
        }
        
        // System.out.println(Arrays.toString(have));
        
        int ans = 0;
        for (int i = 1; i <= N; i++){
            if (have[i] > 0) ans++;
        }
        
        return ans;
    }
}