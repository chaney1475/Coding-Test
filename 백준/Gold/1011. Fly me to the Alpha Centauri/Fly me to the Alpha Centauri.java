import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            
            long d = y - x;

            int k = 0;  
            long max = 0;
            int move = 1;

            while (max < d) {
                k++;
                
                if (k % 2 == 1) {
                    max += move;
                } else {
                    max += move;
                    move++;
                }
            }

            sb.append(k).append("\n");
        }

        System.out.print(sb);
    }
}
