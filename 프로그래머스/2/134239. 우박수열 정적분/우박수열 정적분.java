/*
한 구간 구하기 a  * (a + 1) / 2
시작점이 끝점보다 크면 -> -1
start end 구해야함!

둘중에 더 낮은 높이 +
둘의 차이 / 2


*/
import java.util.*;

class Solution {
    static List<Double> point;
    
    public double[] solution(int k, int[][] ranges) {
        
        int N = ranges.length;
        
        double[] ans = new double[N];
        point = new ArrayList<>();
        
        makePoint((double)k);
        
        // System.out.println(point);
        
        int S = 0;
        int E = point.size()-1;
        
        for (int i = 0; i < N; i++){
            int[] now = ranges[i];
            
            int start = now[0];
            int end = E + now[1];
            
            if (start > end) {
                ans[i] = -1.0;
            }else if (start < end){
                ans[i] = cal(start, end);
            }
            
        }
        
        
        return ans;
    }
    
    static double cal(int start, int end){
        
        double sum = 0.0;
        
        for (int i = (int)start; i < end; i++){
            double t1 = point.get(i);
            double t2 = point.get(i + 1);
            sum += Math.min(t1, t2) + Math.abs(t1 - t2) / 2;
            // System.out.println(Math.min(t1, t2) + Math.abs((int)t1, (int)t2) / 2);
        }
        
        return sum;
        
    }
    
    static void makePoint(double k){
        
        point.add(k);
        
        while(k != 1){
            if (k % 2 == 0){
                k = k / 2;
            }else{
                k = k * 3 + 1;
            }
            point.add(k);
        }
        
    }
}