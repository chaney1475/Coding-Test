import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	static int[] temp;
	static int L;
	static int C;
	static int[] alpha;
	
	static HashSet<Integer> aeiou = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 암호 만들기
		alpha = new int[26]; // 0,4,8,14,20
		
		aeiou.add(0);
		aeiou.add(4);
		aeiou.add(8);
		aeiou.add(14);
		aeiou.add(20);
		
		String[] line = br.readLine().split(" ");
		
		L = Integer.parseInt(line[0]);
		C = Integer.parseInt(line[1]);
		
		String[] s = br.readLine().split(" ");
		
		for (int c = 0; c < C; c++) {
			alpha[s[c].charAt(0) - 'a']++;;
		}
		
		temp = new int[L]; // L개 만들기
		
		make(0,0,sb);
		
		System.out.println(sb);
		

	}
	static void make(int index , int cnt, StringBuilder sb) {
		
		if (cnt == L) {
			int aeCnt = 0;
			String password = "";
			
			for (int i = 0; i < L; i++) {
				if (aeiou.contains(temp[i])) aeCnt++;
				password += (char) ('a' + temp[i]);
			}
			
			if (aeCnt < 1 || L - aeCnt < 2) {
				return;
			}
			sb.append(password).append("\n");
			return;
		}
		
		if (index == 26) {
			return;
		}
		
		for (int i = index; i < 26; i++) {
			if (alpha[i] != 0) {
				alpha[i]--;
				temp[cnt] = i;
				make(i +1 , cnt + 1, sb);
				alpha[i]++;
			}
		}
		
	}

}
