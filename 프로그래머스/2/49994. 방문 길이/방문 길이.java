import java.util.*;

// 좌표 (-5, -5) 부터 (5, 5) 니까
// + 5해서
// (0,0) 부터 (10, 10)으로 보정
// 0보다 작거나 10보다 초과 불가능
// 위치 저장시 다음과 같이 저장

class Solution {
    int[] dx = new int[]{0,0,-1,1};
    int[] dy = new int[]{-1,1,0,0};
    Set<Integer> set = new HashSet<>();
    
    public int solution(String dirs) {
        int answer = 0;
        int x = 0;
        int y = 0;
        
        int nx, ny;

        Map<Character, int[]> ds = new HashMap<>();
        ds.put('U', new int[]{-1,0});
        ds.put('D', new int[]{1,0});
        ds.put('R', new int[]{0,1});
        ds.put('L', new int[]{0,-1});
        
        int n = dirs.length();

        int[] dNow;

        for (int i = 0; i < n; i++) {
            char d = dirs.charAt(i);
            dNow = ds.get(d);
            nx = dNow[0] + x;
            ny = dNow[1] + y;
            if (nx < -5 ||  nx > 5 || ny < -5 || ny > 5) continue;
            
            // 가능한 경우에는 이동
            makePath(new int[]{x,y}, new int[]{nx, ny});
            x = nx;
            y = ny;
        }

        return set.size();
    }
    
    public void makePath(int[] s, int[] e){
        // 위치 보정
        s[0]+=5;
        s[1]+=5;
        e[0]+=5;
        e[1]+=5;
        
        // 10이 최대니까
        int now = s[1] * 100 + s[0];  // 최대 1010 * 10000 
        int next = e[1] * 100 + e[0]; // 최대 1010

        if (next > now) {
            int tmp = next;
            next = now;
            now = tmp;
        }

        int path = now * 10000 + next;

        set.add(path);
    }
}