import java.util.*;
import java.io.*;

public class Main {
    static int[][] map = new int[10][7];
    
    static String N;
    static int K;
    static int P;
    static String x;
    
    static int[] temp;
    static int ans;
    
    public static void main(String args[]) throws Exception {

        map[0] = new int[]{1, 1, 1, 1, 1, 1, -1};
        map[1] = new int[]{-1, -1, 1, 1, -1, -1, -1};
        map[2] = new int[]{-1, 1, 1, -1, 1, 1, 1};
        map[3] = new int[]{-1, 1, 1, 1, 1, -1, 1};
        map[4] = new int[]{1, -1, 1, 1, -1, -1, 1};
        map[5] = new int[]{1, 1, -1, 1, 1, -1, 1};
        map[6] = new int[]{1, 1, -1, 1, 1, 1, 1};
        map[7] = new int[]{-1, 1, 1, 1, -1, -1, -1};
        map[8] = new int[]{1, 1, 1, 1, 1, 1, 1};
        map[9] = new int[]{1, 1, 1, 1, 1, -1, 1};
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
      
        N = st.nextToken(); // 가능한 최대 수
        K = Integer.parseInt(st.nextToken()); // K자리의 수
        P = Integer.parseInt(st.nextToken()); // 반전 갯수
        x = st.nextToken(); // 실제 층
        
        ans = 0;
        temp = new int[K];
        int len = x.length();
        
        for (int i = 0; i < len; i++){
            temp[K - len + i] = x.charAt(i) - '0';
        }
        
        dfs(0, 0, 0);
        
        System.out.println(ans);
    }
    
    static void dfs(int now, int total, int cnt){
        
    	if(cnt > 0 && isSmall() && now == K) {
    		if (!isZero()) {  // 숫자가 0이 아닌지 확인
    		    ans++;
    	    }
    	}
    	
    	if (now == K) return;
    	
    	int ori = temp[now]; //원래 수
    	
    	for (int i = 0; i < 10; i++) {
    		if (i == ori) continue;
    		int c = getCnt(ori, i);
    		if (c +  total <= P) {
    			temp[now] = i;
				dfs(now + 1, c + total, cnt + 1);
				temp[now] = ori;
    		}
    	}
    	
    	dfs(now + 1, total, cnt);
    	
    }
    
    static int getCnt(int now, int next) {
    	int sum = 0;;
    	for (int i = 0; i < 7; i++) {
    		if (map[now][i] * map[next][i] == -1) sum++;
    	}
    	return sum;
    }
    
    static boolean isSmall() {
        for (int i = 0; i < K; i++) {
            if (temp[i] > N.charAt(i) - '0') {
                return false;
            } else if (temp[i] < N.charAt(i) - '0') {
                return true;
            }
        }
        return true;
    }
    
    static boolean isZero() {
        for (int i = 0; i < K; i++) {
            if (temp[i] != 0) return false;
        }
        return true;
    }
    
}