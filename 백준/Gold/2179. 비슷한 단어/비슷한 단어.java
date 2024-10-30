import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int ans = 0;
		String[] str = new String[N];
		
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}
		
		String a1 = "";
		String a2 = "";
		
		
		// 모든 단어 쌍을 비교
        for (int i = 0; i < N; i++) {
        	String before = str[i];
            for (int j = i + 1; j < N; j++) {
            	int cnt = 0;
            	String now = str[j];
            	
            	for (int k = 0; k < Math.min(now.length(), before.length()); k++) {
    				if (now.charAt(k) != before.charAt(k)) break;
    				cnt++;
    			}
            	
            	if(ans < cnt) {
    				ans = cnt;
    				a1 = before;
    				a2 = now;
    			}
            }
        }
        
		System.out.println(a1 + "\n" + a2);
	}
}
