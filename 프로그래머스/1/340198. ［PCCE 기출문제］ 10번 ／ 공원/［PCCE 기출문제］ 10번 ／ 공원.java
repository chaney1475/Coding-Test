import java.util.*;
    
class Solution {
    int N;
    int M;
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        Arrays.sort(mats);
        N = park.length;
        M = park[0].length;
        
        int ans = -1;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans = Math.max(square(park, i, j) + 1, ans);
            }
        }
        for (int i = mats.length - 1; i >= 0 ; i--) {
            if (mats[i] <= ans) {
                answer = mats[i];
                break;
            }
        }
        return answer;
    }
    public int square(String[][] park, int x, int y) {
        
        int L = Math.min(N - x, M - y);
        
        int result = -1;
        for (int l = 0; l < L; l++) { // 그 길이 만큼
            if (check(park, l, x, y)) {
                result = l;
            } else {
                break;
            }
        }
        return result;
    }
    public boolean check(String[][] park, int L, int x, int y) {
        // System.out.println("x : " + x  + ", y:" + y + ", L:" + L);
        
        for (int i = 0; i <= L; i++) {
            // System.out.println((i + x) + "," + (y + L) + " | " + (x + L) + ", " + (i + y) + "\n");
            
            if (!park[i + x][y + L].equals("-1") || !park[x + L][i + y].equals("-1")) {
                return false;
            }
        }
        return true;
    }
}