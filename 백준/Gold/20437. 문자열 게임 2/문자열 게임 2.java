import java.util.*;
import java.io.*;

public class Main
{
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String str = br.readLine();
			int K = Integer.parseInt(br.readLine());

			if (K == 1) {
				System.out.println("1 1");
				continue;
			}
			
			//위치를 list로 다 저장하기
			List<Integer>[] list = new ArrayList[26];
			
			for (int i = 0; i < 26; i++) {
				list[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < str.length(); i++) {
				list[str.charAt(i) - 'a'].add(i);
			}
			
			int min = str.length() + 1;
			int max = -1;
			
			for (int i = 0; i < 26; i++) {
				List<Integer> now = list[i];
				
				if (list[i].size() < K) continue;
				//k개 이상 있는 경우!
				int e = K - 1;
				//k개만큼 끝을 더해주자
				
				for(int j = e; j < list[i].size(); j++) {
					int tmp = now.get(j) - now.get(j - K + 1) + 1;
					min = Math.min(min, tmp);
					max = Math.max(max, tmp);
				}	
			}
			
			if (min == str.length() + 1 && max == -1) {
				System.out.println(-1);
				continue;
			}else {
				System.out.println( min + " " + max );
				continue;
			}
			
		}
		
	}
}
