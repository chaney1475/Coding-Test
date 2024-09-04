import java.util.*;
import java.io.*;

public class Solution {
    static int[] fee = new int[4]; 
    static int[] date = new int[14];
    static int[] plan = new int[13];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            for(int i = 2; i < 14; i++) date[i] = Integer.MAX_VALUE;
            for(int i = 0; i < 4; i++) fee[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i < 13; i++) plan[i] = Integer.parseInt(st.nextToken());
            
            //date[n]은 n전 날까지의 최소 비용
            // 즉 n+1일 n일의 최소값임

//            System.out.println(Arrays.toString(date));
            for(int n = 0; n < 13; n++) {
            	if(n+1 <= 13 && fee[0] * plan[n] + date[n] < date[n+1]) {
                    date[n+1] = fee[0] * plan[n] + date[n];
                }
                //1달권
                if(n+1 <= 13 && fee[1] + date[n] < date[n+1]) {
                    date[n+1] = fee[1] + date[n];
                }
                //3달권
                if(n+3 <= 13 && fee[2] + date[n] < date[n+3]) {
                    date[n+3] = fee[2] + date[n];
                }
                //1년권
                if(n+12 <= 13 && fee[3] + date[n] < date[n+12]) {
                    date[n+12] = fee[3] + date[n];
                }
//               System.out.println(Arrays.toString(date));
            }
            
            
            System.out.printf("#%d %d\n", t, date[13]);
        }
        

    }

}