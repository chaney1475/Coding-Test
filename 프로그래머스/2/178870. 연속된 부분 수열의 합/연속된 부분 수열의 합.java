import java.util.*;

class Solution {
    public int[] solution(int[] a, int k) {
        int[] answer = new int[2];
        
        Arrays.sort(a);
        
        int s = 0;
        int e = 0;
        
        long K = (long) k;
        int N = a.length;
        
        long tmp = 0;
        
        long len = N + 1;
        
        //작으면 e를 늘림 크면 크면 왼쪽을 오른쪽으로 함
        while(e < N) {
            tmp += a[e];
            while(tmp >= K){
                if(tmp == K && (e - s + 1) < len){
                    answer[0] = s;
                    answer[1] = e;
                    len = e - s + 1;
                }
                tmp -= a[s];
                s++;
            }
            e++;
        }
        return answer;
        
    }
}