import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 8진수 2진수
		
		//314 -> 3개씩 잘라서 2진수 만들기
		String s = br.readLine();
		int len = s.length();
		StringBuilder ans = new StringBuilder();
		
		for (int i = 0; i < len; i++) {
			int a = s.charAt(i) - '0';
			StringBuilder sb = new StringBuilder();
			
			while(a != 0) {
				sb.append(a % 2);
				a /= 2;
			}
			while(i != 0 && sb.toString().length() != 3) {
				sb.append("0");
			}
			ans.append(sb.reverse());
		}
		if (ans.toString().length() == 0) {
			System.out.println(0);
		}else {
			System.out.println(ans);
		}

	}

}
