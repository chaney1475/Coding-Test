import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int num;
	static int r;
	static int c;
	//Z
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		num = 0;
		
		System.out.println(make(0, 0, N, 0));
		
	}
	
	public static int make(int x, int y, int n, int front) {
		
		if (n == 1){ // 채우기
			return front;
		}
		
		int nx = x;
		int ny = y;
		
		int f = (n/2) * (n/2);
		
		if (r >= x + n/2) {
			nx = x + n/2;
			front += f * 2;
		}
		if (c >= y + n/2) {
			ny = y + n/2;
			front += f;
		}

		return make(nx, ny, n/2, front);
	}
}
