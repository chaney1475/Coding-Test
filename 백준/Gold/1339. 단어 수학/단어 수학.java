
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N; //단어 갯수
	
	static int[] candi; // 후보가 될 숫자들
	
	static boolean[] visited; // 알파벳을 방문 했는지
	
	static int[] temp;
	
	static int possible; // 가능한 숫자의 갯수
	
	static int[] alpha_index;
	
	static int answer;
	
	static String[] words;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int[] alpha = new int[26];
		
		words = new String[N]; 
		
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine().trim();
			words[i] = s;
			for (int j = 0; j < s.length(); j++) {
				alpha[s.charAt(j) - 'A'] = 1;
				
			}
		}
		
		alpha_index = new int[26];
		int start_index = 0;
		
		for (int i = 0; i < 26; i++) {
			if (alpha[i] != 0) {
				alpha_index[i] = start_index++;
			}
		}
		
		possible = start_index;
		
		answer = 0;
		
		visited = new boolean[possible];
		candi = new int[possible];
		temp = new int[possible];
		
		int index = 0;
		for (int i = 9; i > 9 - possible; i--) {
			candi[index++] = i;
		}
		
		make(0);
		System.out.println(answer);
		
	}
	static void make(int index) {
		if (index == possible) {
			makeNum(temp);
			return;
		}
		
		for (int i = 0; i < possible; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[index] = candi[i];
				make(index + 1);
				visited[i] = false;
			}
		}
		
	}
	
	static void makeNum(int[] numbers) {
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			 String s = words[i];
			 int temp = 0;
			 for (int si = 0; si < s.length(); si++) {
				 temp = temp * 10;
				 temp += numbers[alpha_index[s.charAt(si) - 'A']];
			 }
			 sum += temp;
		}
		
		if (sum > answer) {
			answer = sum;
		}
	}
	

}
