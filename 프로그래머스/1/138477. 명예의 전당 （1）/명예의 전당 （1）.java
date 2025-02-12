import java.util.*;
/*
갯수가 부족할때는 일단 offer 아닌 경우에는 비교해서 작은 경우에 poll 하고 offer

*/


class Solution {
    public int[] solution(int k, int[] score) {
        
        int N = score.length;
        int[] answer = new int[N];
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        
        for (int i = 0; i < N; i++){
            int now = score[i];
            
            if (q.size() < k){
                q.offer(now);
            }else{
                if (q.peek() < now){
                    q.poll();
                    q.offer(now);
                }
            }
            // System.out.println(q);
            answer[i] = q.peek();
        }
        
        
        return answer;
    }
}