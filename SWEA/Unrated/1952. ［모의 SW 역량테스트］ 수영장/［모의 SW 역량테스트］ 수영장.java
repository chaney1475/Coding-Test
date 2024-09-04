import java.util.*;
import java.io.*;

public class Solution {
    static int[] fee = new int[4]; 
    static int[] plan = new int[13];
    static int[] dp = new int[13];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
        	// 요금제 입력 받기
            st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < 4; i++) {
                fee[i] = Integer.parseInt(st.nextToken()); // 하루, 한 달, 세 달, 1년 요금 입력
            }

            // 각 달의 수영장 이용 계획 입력 받기
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            
            for (int i = 1; i <= 12; i++) {
            	dp[i] = Math.min(dp[i], dp[i-1] + plan[i] * fee[0]);
            	
            	dp[i] = Math.min(dp[i], dp[i-1] + fee[1]);
            	
            	if (i >= 3) {
            		dp[i] = Math.min(dp[i], dp[i-3] + fee[2]);
            	}else {
            		dp[i] = Math.min(dp[i], fee[2]);
            	}
            	
            }
            
           dp[12] = Math.min(dp[12], fee[3]);
            
            System.out.printf("#%d %d\n", t, dp[12]);
        }
        

    }

}