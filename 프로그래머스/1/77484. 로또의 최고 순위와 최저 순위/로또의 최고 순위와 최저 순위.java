import java.util.*;
// 6개 1등 / 5개 2등 / 4개 3등 /3개 4등 /2개 5등
// 6등 

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        Set<Integer> numSet = new HashSet<>();
        
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] != 0) {
                numSet.add(lottos[i]);
            } 
        }
        
        int zeroCnt = 6 - numSet.size();
        
        int W = win_nums.length;
        
        int matchCnt = 0;
        for (int i = 0; i < W; i++) {
            if (numSet.contains(win_nums[i])){
                matchCnt++;
            }
        }
        
        int best = zeroCnt + matchCnt;
        int worst = matchCnt;
        int[] score = new int[] {6,6,5,4,3,2,1};
        
        answer[0] = score[best];
        answer[1] = score[worst];
        
        return answer;
    }
}