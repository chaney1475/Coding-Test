import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] result;
	static boolean[] visited;
	
	static int n;
	static int m;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 숫자
		
		m = Integer.parseInt(st.nextToken()); // 정답에 뭐가 들어갈지
		
		result = new int[m];
		
		visited = new boolean[n]; // 방문한 인덱스 인지
		
		function(bw, 0);
		bw.flush();
		bw.close();
	}
	
	public static void function(BufferedWriter bw, int index) throws IOException {
		
		
		if(index == m) { // 끝까지 온경우
			for (int num : result) {
	                bw.write((num+1) + " "); // 숫자를 출력하고 줄 바꿈
	        }
			bw.write("\n");
			
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				result[index] = i;
				function(bw, index + 1);
				visited[i] = false;
				
			}
		}
	}
	

}
