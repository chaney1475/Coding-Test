import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;

    public static void main(String[] args) throws IOException {
        // 보물상자
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            Set<String> hexSet = new HashSet<>(); // 중복 제거를 위한 Set
            
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // N은 문자열 길이
            int K = Integer.parseInt(st.nextToken()); // K번째로 큰 값

            String str = br.readLine();
            
            int len = N / 4;
            
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < 4; j++) {
                	
                    int start = j * len + i;
                    int end = start + len;
                    
                    if (end > N) {
                        String s = str.substring(start, N) + str.substring(0, end % N);
                        hexSet.add(s);
                    } else {
                        hexSet.add(str.substring(start, end));
                    }
                }
            }
            
            List<String> numbers = new ArrayList<>(hexSet);
            Collections.sort(numbers, (o1, o2) -> Long.compare(Long.parseLong(o2, 16), Long.parseLong(o1, 16)));

            // K번째로 큰 값을 가져옴
            String ansS = numbers.get(K - 1);

            long s = Long.parseLong(ansS, 16);

            System.out.printf("#%d %d\n", t, s);
        }
    }
}
