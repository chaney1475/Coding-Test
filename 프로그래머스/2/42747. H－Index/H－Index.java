import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int N = citations.length;
        
        Arrays.sort(citations);
        //뒤에서부터 센 갯수가 현재 수보다 같거나 클때까지
        
        int cnt = 0;
        // System.out.println(Arrays.toString(citations));
        for (int i = N-1; i >= 0; i --){
            if (cnt >= citations[i]) break;
            cnt++;
        }
        
        return cnt;
    }
}