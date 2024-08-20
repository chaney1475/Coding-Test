import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
	// 농작물 수확하기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] sugar = new int[N + 1];
		
		Arrays.fill(sugar, Integer.MAX_VALUE);
		
		sugar[3] = 1;
		if (N >= 5) sugar[5] = 1;
		
		for (int j = 3; j < N +1; j++) {
			if (sugar[j] > sugar[j - 3]) {
				sugar[j] = sugar[j - 3] + 1;
			}
		}
		
		for (int j = 5; j < N +1; j++) {
			if (sugar[j] > sugar[j - 5]) sugar[j] = sugar[j - 5] + 1;
		}
		if (sugar[N] == Integer.MAX_VALUE)
			sugar[N] = -1;
		System.out.println(sugar[N]);
		
	}

}
