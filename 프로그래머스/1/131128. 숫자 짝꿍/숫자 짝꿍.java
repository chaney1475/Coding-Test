import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        int[] x = new int[10];
        int[] y = new int[10];
        
        int nx = X.length();
        int ny = Y.length();
        
        for (int i = 0; i < nx; i++){
            x[X.charAt(i) - '0']++;
        }
        for (int i = 0; i < ny; i++){
            y[Y.charAt(i) - '0']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 9; i >= 0; i--){
            int cnt = Math.min(x[i], y[i]);
            for (int c = 0; c < cnt; c++){
                sb.append(i);
            }
        }
        if (sb.length() == 0) return "-1";
        else if (sb.charAt(0) =='0') return "0"; 
        
        return sb.toString();
    }
}