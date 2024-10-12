import java.util.*;

class Solution {
    public int solution(int[] bandage, int limit, int[][] attacks) {
        int answer = 0;
        int health = limit; //일단 최대 
        
        int N = attacks.length; //공격의 길이
        int attackIdx = 0; // 현재 어떤 공격이 들어올지
        int time = 0; // 흐르는 시간
        
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        
        int success = 0;
        
        while (attackIdx < N){
            time ++; // 1초 부터 시작
            int attackTime = attacks[attackIdx][0];
            int attackAmount = attacks[attackIdx][1];
            
            if (attackTime == time){
                //공격 시간이 현재 시간인 경우
                health -= attackAmount;
                success = 0;
                if (health <= 0){
                    break;
                }
                attackIdx++;
                
            }else{
                health += x;
                success++;
                if (success >= t){
                    health += y;
                    success = 0;
                }
                if (health > limit){
                    health = limit;
                }
            }
            // System.out.println(t + "초 일때 health :" + health + " 연속 성공: " + success);
        }
        if (health <= 0) return -1;
        else return health;
    }
}