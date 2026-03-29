import java.util.*;
// 롤케이크를 반으로 크기보다 올려진 토킹의 종류가 중요 동일한 가짓수의 토핑인 경우 공평
class Solution {
    public int solution(int[] topping) {
        
        int answer = 0;
        
        int cnt1 = 0;
        int cnt2 = 0;
        
        int n = topping.length;
        
        int[] t1 = new int[10001];
        int[] t2 = new int[10001];
            
        for (int i = 0; i < n; i++) {
            t2[topping[i]]++;
            // 방금 추가되어 1이 된 경우 종류에 추가
            if (t2[topping[i]] == 1) {
                cnt2++;
            }
        }
        
        for (int i = 0; i < n; i++) {
            //t1은 i까지
            int now = topping[i];
            
            t1[now]++;
            if (t1[now] == 1) {
                cnt1++;
            }
            
            t2[now]--;
            if (t2[now] == 0) {
                cnt2--;
            }
            
            if (cnt1 == cnt2) {
                answer++;
            }
        }
        
        return answer;
    }
}