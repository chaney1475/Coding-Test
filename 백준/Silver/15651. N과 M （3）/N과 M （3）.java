import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int[] temp;
	static String[] answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		

		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 중복 순열
		temp = new int[m];
		
		//
		make(0, sb);
		System.out.println(sb);

	}
	
	
	static void make(int index, StringBuilder sb){
		
		
		if (index == m) {
			for (int i = 0; i < m; i++) {
				sb.append(temp[i] + 1).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < n; i++) {
			temp[index] = i;
			make(index + 1, sb);
		}
		
	}

}
