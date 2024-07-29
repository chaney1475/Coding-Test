import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] array;
    static int N;

    public static int BSearch(int num){
        int start = 0;
        int end = N-1;
        int mid;

        while(start <= end){
            mid = (start + end) / 2;
            if (array[mid] < num) start = mid + 1;
            else if (array[mid] > num) end = mid - 1;
            else return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine()); // 숫자 한개 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array); // 배열 정렬

        int cnt = Integer.parseInt(br.readLine()); // 확인 갯수
        st = new StringTokenizer(br.readLine());
        int[] check = new int[cnt];
        for(int i = 0; i< cnt; i++){
            check[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            sb.append(BSearch(check[i])).append('\n');
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
