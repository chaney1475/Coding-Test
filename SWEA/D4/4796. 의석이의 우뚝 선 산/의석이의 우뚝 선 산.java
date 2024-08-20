import java.util.Scanner;

public class Solution {
    static int N;

    //의석이의 우뚝 선산
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            
            N = sc.nextInt();
            int[] num = new int[N];
            
            for(int i = 0; i < N; i++) {
                num[i] = sc.nextInt();
            }
            
            boolean[] incre = new boolean[N];
            boolean[] decre = new boolean[N];
            
            for(int i = 1; i < N; i++) {
                if(num[i-1] < num[i]) {
                    incre[i] = true;
                }
            }
            
            for(int i = 0; i < N-1; i++) {
                if(num[i] > num[i + 1]) {
                    decre[i] = true;
                }
            }
            
            int answer = 0;
            
            int top_index = 0;
            int tops[] = new int[N];
            
            for (int i = 0; i < N; i++) {
                if (incre[i] && decre[i]) {
                    tops[top_index++] = i;
                }
                
            }
            
            // 각 인덱스에서 좌우에 얼만큼 갈 수 있는지 확인
            // incre의 경우 왼쪽도 true이어야함 - l
            // decre의 경우 오른쪽도 true이어야함 - r
            
            for (int i = 0; i < top_index; i++) { // 각 산마다 확인
                
                int left = 1;
                int right = 1;
                
                int l = tops[i] - 1;
                int r = tops[i] + 1;
                
                while (l >= 0 && incre[l]) {
                    l--;
                    left++;
                }
                while (r < N && decre[r]) {
                    r++;
                    right++;
                }
                answer += (left * right);
            }
            
            System.out.printf("#%d %d\n", t, answer);
        }
        
        sc.close();
    }
}
