/*
0 4
5 9
10
*/
import java.util.*;
class Solution {
    static String[] mins;
    static int N;
    static int[] tmp;
    
    static int cnt;
    static int answer;
    
    static int toolSum;
    
    static int[][] tired;
    
    // tmp[0] 다이아의 남은 곡궹이 수 tmp[1] 철 tmp[2] 돌
    
    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        
        mins = minerals;
        N = minerals.length;
        
        toolSum = picks[0] + picks[1] + picks[2];
        
        tmp = picks;
        
        tired = new int[3][3];
        
        tired[0] = new int[] {1,1,1};
        tired[1] = new int[] {5,1,1};
        tired[2] = new int[] {25,5,1};
        
            
        dfs(0, 0, 0);        
        
        return answer;
    }
    
    static void dfs(int num, int ans, int cnt){
        //ans는 피로도
        // num에서 num + 4까지 캐기
        if (num > N || cnt == toolSum){
            //끝까지 왓다는 뜻
            answer = Math.min(ans, answer);
            return;
        }
        
        for (int i = 0; i < 3; i++){
            if (tmp[i] > 0){
                tmp[i]--;
                dfs(num + 5, ans + getTired(num, i), cnt + 1);
                tmp[i]++;
            }
        }
    }
    
    static int getTired(int num, int tool){
        int sum = 0;
        
        for (int i = num; i < Math.min(num + 5, N); i++){
            String name = mins[i];
            
            if (name.equals("diamond")){
                sum += tired[tool][0];
            }else if (name.equals("iron")){
                 sum += tired[tool][1];
            }else{
                 sum += tired[tool][2];
            }
            
        }
        return sum;
    }
    
}