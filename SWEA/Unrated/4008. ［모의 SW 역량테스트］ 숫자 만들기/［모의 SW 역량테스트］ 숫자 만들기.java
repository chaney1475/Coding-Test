import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	
	static int num[];
	static int cal[];
	
	static int[] selected;
	static int maxA;
	static int minA;
	
	
	// 숫자 만들기
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			
			st = new StringTokenizer(br.readLine());
			cal = new int[4];
			
			for (int j = 0; j < 4; j++) {
				cal[j] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			num = new int[N];
			
			for (int j = 0; j < N; j++) {
				num[j] = Integer.parseInt(st.nextToken());
			}
			
			selected = new int[N-1];
			
			maxA = Integer.MIN_VALUE;
			minA = Integer.MAX_VALUE;
			
			selected = new int[N-1];
			make(0, cal);
			
			System.out.printf("#%d %d\n", t, maxA- minA);
		}
		

	}
	public static void cal() {
		int tmp = num[0];
		for (int i = 0; i < N-1 ; i++) {
			if(selected[i] == 0) {
				tmp += num[i+1];
			}else if (selected[i] == 1) {
				tmp -= num[i+1];
			}else if(selected[i] == 2) {
				tmp *= num[i+1];
			}else {
				tmp /= num[i+1];
			}
		}
		if (minA > tmp) {
			minA =tmp;
		}
		if (maxA < tmp) {
			maxA = tmp;
		}
	}
	public static void make(int index, int[] cal) {
		if (index == N-1) {
			//N-1개를 뽑아서 완성된 경우
			cal();
			return;
		}
		
		for (int i = 0 ; i< 4; i++) {
			if (cal[i] == 0) {
				continue;
			}
			cal[i]--;
			selected[index] = i;
			make(index + 1, cal);
			cal[i]++;
			
		}
		
	}
	
}
