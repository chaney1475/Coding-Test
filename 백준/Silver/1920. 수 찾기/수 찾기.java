import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

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

        N = Integer.parseInt(br.readLine());// 숫자 한개 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        array = Arrays.stream(array).sorted().toArray();

        int cnt = Integer.parseInt(br.readLine());// 확인 갯수
        st = new StringTokenizer(br.readLine());
        int[] check = new int[cnt];
        for(int i = 0; i< cnt; i ++){
            check[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < cnt; i++) {
            System.out.println(BSearch(check[i]));
        }


    }
}
