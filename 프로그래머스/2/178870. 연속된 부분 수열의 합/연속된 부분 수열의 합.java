import java.util.*;

class Solution {
    public int[] solution(int[] a, int k) {
        int[] answer = new int[2];
        
        Arrays.sort(a);
        
        int s = 0;
        int e = 0;
        
        long K = (long) k;
        int N = a.length;
        
        long tmp = a[s];
        
        long len = N + 1;
        
        //작으면 e를 늘림 크면 크면 왼쪽을 오른쪽으로 함
        while(e < N) {
            //갱신
            if(tmp == K && (e - s + 1) < len){
                answer[0] = s;
                answer[1] = e;
                len = e - s + 1;
            }
            
            if (e == N - 1 && s == N - 1) break;
            
            //조정
            if (tmp <= K){
                if (e == N - 1) break;
                e++;
                tmp += a[e];
            }else {
                if (s == N - 1) break;
                tmp -= a[s++];
            }
            
        }
        return answer;
        
    }
}