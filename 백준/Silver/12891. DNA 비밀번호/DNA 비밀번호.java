import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int answer;

	public static void main(String[] args) throws IOException { // DNA 비밀번호

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] dna = new int[4]; // 포함해야하는 갯수
		int[] cnt = new int[4]; // 실제 갯수

		HashMap<Character, Integer> dna_map = new HashMap<>();

		dna_map.put('A', 0);
		dna_map.put('C', 1);
		dna_map.put('G', 2);
		dna_map.put('T', 3);

		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken()); // 비밀번호의 길이

		String dna_str = br.readLine().trim();

		answer = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			dna[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < P; i++) {
			char c = dna_str.charAt(i);
			cnt[dna_map.get(c)]++;
		}
		

		check(dna, cnt);

		for (int i = 0; i < S - P; i++) {
			cnt[dna_map.get(dna_str.charAt(i))]--;
			cnt[dna_map.get(dna_str.charAt(P + i))]++;
			check(dna, cnt);
		}
		
		System.out.println(answer);

	}

	public static void check(int[] dna, int[] cnt) {
		for (int i = 0; i < 4; i++) {
			if (dna[i] > cnt[i])
				return;
		}
		answer++;
	}

}
