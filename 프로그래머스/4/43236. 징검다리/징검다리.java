import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int ans = 0;
        int target = rocks.length - n + 1; // 만족해야하는 돌의 수
        
        //최소 길이
        int s = 0;
        int e = distance + 1;
        
        Arrays.sort(rocks);
        
        while (s <= e){
            int m = (int) (((long) s + (long) e) / 2);
            if (check(distance, rocks, m) >= target){
                //많거나 같으면 일단 된거임 근데 많으니까 크기를 늘려야함!
                ans = m;
                s = m + 1;
            }else{
                e = m - 1;
            }
        }
        
        return ans;
    }
    
    int check(int distance, int[] rocks, int m){
        //최소 길이가 m이 될때의 가능한 돌의 수
        int cnt = 0;
        int now = m;
        //마지막 돌이랑 끝도 확인해야함
        
        for (int i = 0; i < rocks.length; i++){
            if (now <= rocks[i]){
                //같거나 크면 세야함
                now = rocks[i] + m;
                cnt++;
            }
        }
        if (now <= distance){
            cnt++;
        }
        
        return cnt;
    }
}