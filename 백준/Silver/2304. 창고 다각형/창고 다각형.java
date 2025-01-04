import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] building= new int[N][2];
        
        int maxIndex = -1;
        int maxHeight = -1 ;
        
        for (int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            building[i][0] = a;
            building[i][1] = b;
        }
        
        Arrays.sort(building, (a,b) -> a[0] - b[0]);
        
        int s = building[0][0];
        int h = building[0][1];
        
        for (int i = 0; i < N; i++){
            int[] now = building[i];
            if(maxHeight < now[1]){
                maxHeight = now[1];
                maxIndex = i;
            }
        }
        
        int ans = 0;
        
        //그 제일 큰 값 올때까지 증가하는 수만 기록
        for (int i = 1; i <= maxIndex ; i++){
            int[] now = building[i];
            if (h < now[1]){
                ans += h * (now[0] - s);
                s = now[0];
                h = now[1];
            }
        }
        
        s = building[N-1][0];
        h = building[N-1][1];
        
        for (int i = N - 1; i >= maxIndex; i--){
            int[] now = building[i];
            if (h <= now[1]){
                ans += h * (s - now[0]);
                s = now[0];
                h = now[1];
            }
            
        }
        ans += maxHeight;
        
        System.out.print(ans);
    }
}