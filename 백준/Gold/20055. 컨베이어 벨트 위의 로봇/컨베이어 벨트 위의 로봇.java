import java.util.*;
import java.io.*;


public class Main{
    static int[] A;
    static boolean[] robot;
    static int N;
    static int K;
    
  public static void main(String args[]) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    
    st = new StringTokenizer(br.readLine());
    
    A = new int[N*2];
    for (int i = 0;  i< N*2; i++){
        A[i] = Integer.parseInt(st.nextToken());
    }
    
    robot = new boolean[N*2];
    System.out.println(make());
    
    
  }
  static int make(){
      int s = 0; // 시작점, 올리는 점
      int e = N-1; // 끝점, 내리는 점
      
      int cnt = 0;
    
    int step = 0;
    
    while(cnt < K){
        step++;
        // 회전
        s = (s - 1 + 2* N) % (2 * N);
        e = (e - 1 + 2* N) % (2 * N);
        
        if(robot[e]) robot[e] = false;
        
        int targetIdx = e;
        
        for (int j = 0; j < N-1; j++){
            int now = (targetIdx - j + 2*N) % (2 * N); // 현재 위치를 계산
            int beforeNow = (now - 1 + 2 * N) % (2 * N); // 이전 위치를 계산
            
            if (!robot[now] && robot[beforeNow] && A[now] > 0){
                
                robot[now] = true;
                robot[beforeNow] = false;
                A[now]--;
                
                if(A[now] == 0) cnt++;
                if(cnt >= K) return step;
            }
        }
        
        if(robot[e]) robot[e] = false;
        
        if (A[s] > 0){
            robot[s] = true;
            A[s]--;
            if(A[s] == 0) cnt++;
            if(cnt >= K) return step;
        }
        
    }
    
    return step;
  }
}