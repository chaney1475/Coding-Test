import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        int n = score.length;
        
        int i = n - m;
        
        while (i >= 0){
            answer += Math.min((score[i]), k) * m;
            i -= m;
        }
        
        return answer;
    }
}