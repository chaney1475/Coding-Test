import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        
        int N = queries.length;
        int M = arr.length;
        
        for (int i = 0; i < N; i++){
            int[] cur = queries[i];
            int s = cur[0];
            int e = cur[1];
            int k = cur[2];
            
            for (int j = 0; j < M; j++){
                if (j >= s && j <= e && j % k == 0){
                    arr[j] += 1;
                }
            }
        }
        
        return arr;
    }
}