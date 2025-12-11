import java.math.*;
import java.util.*;


class Solution {
    public int[] solution(String[] wallpaper) {
        
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        
        int maxX = -1;
        int maxY = -1;
        
        int minX = n;
        int minY = m;
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                char cur = wallpaper[i].charAt(j);
                if (cur == '#'){
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                    
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                }
            }
        }
        return new int[] {minX, minY, maxX + 1, maxY +1};
        
    }
}