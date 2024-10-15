import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
       
        int N = wallpaper.length;
        int M = wallpaper[0].length();
        
        char[][] map = new char[N][M];
        
        int sx = N;
        int sy = M;
        
        int ex = 0;
        int ey = 0;
        
        
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (wallpaper[i].charAt(j) == '#'){
                    sx = Math.min(sx, i);
                    sy = Math.min(sy, j);
                    
                    ex = Math.max(ex, i);
                    ey = Math.max(ey, j);
                }
            }
            
        }
        
        int[] answer = new int[] {sx, sy, ex + 1, ey + 1};
        return answer;
    }
}