
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		comb(0, 0, new int[M]);
	}
	
	public static void comb(int index, int temp_index, int[] temp) {
		
		if(temp_index == M) {
			for(int i = 0; i < M; i++) {
			System.out.print((temp[i] + 1) + " ");
			}
			System.out.println();
			return;
		}
		
		if (N == index) {
			return;
		}
		
		temp[temp_index] = index;
		
		comb(index + 1, temp_index + 1, temp);
		
		comb(index + 1, temp_index, temp);
		
		
	}

}
