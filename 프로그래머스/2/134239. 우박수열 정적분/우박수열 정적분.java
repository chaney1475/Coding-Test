import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> nums = new ArrayList<>();
        
        double[] answer = new double[ranges.length];
        
        while (k > 1) {
            nums.add(k);
            if (k % 2 == 0) {
                k = k / 2;
            } else {
                k = k * 3 + 1;
            }
        }
        nums.add(1);
        
        int n = nums.size() - 1;
        
        double[] rslts = new double[n];
        
        for (int i = 0; i < n; i++) {
            double h = nums.get(i) + nums.get(i+1);
            double rslt = h / 2;
            rslts[i] = rslt;
        }
        
        for (int i = 0; i < ranges.length; i++) {
            
            int a = ranges[i][0];
            int b = ranges[i][1];
            
            int s = a;
            int e = n + b;
            
            if (s > e) {
                answer[i] = -1;
                continue;
            }
            
            double sum = 0;
            
            for (int j = s; j < e; j++){
                sum += rslts[j];
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}