import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] switchState = new int[N + 1];
        
        // 스위치
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            switchState[i] = Integer.parseInt(st.nextToken());
        }
        
        // 학생
        int M = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());
            
            if (gender == 1) {
                for (int j = position; j <= N; j += position) {
                    switchState[j] = (switchState[j] + 1) % 2; // 스위치 토글
                }
            } else {
                int left = position - 1;
                int right = position + 1;
                switchState[position] = (switchState[position] + 1) % 2; // 자신의 위치 토글
                
                while (left > 0 && right <= N && switchState[left] == switchState[right]) {
                    switchState[left] = (switchState[left] + 1) % 2;
                    switchState[right] = (switchState[right] + 1) % 2;
                    left--;
                    right++;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(switchState[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        
        System.out.print(sb);
    }
}
