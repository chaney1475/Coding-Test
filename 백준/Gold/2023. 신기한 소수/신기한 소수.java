import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] answer;
	static int N;

	static boolean isPrime(int n, int i) {
        // 기본 케이스: 2보다 작은 수는 소수가 아님
        if (n <= 1) {
            return false;
        }
        // i가 n의 제곱근보다 크면 n은 소수임
        if (i * i > n) {
            return true;
        }
        // n이 i로 나누어 떨어지면 소수가 아님
        if (n % i == 0) {
            return false;
        }
        // 다음 숫자로 재귀 호출
        return isPrime(n, i + 1);
    }

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = sc.nextInt();

		answer = new int[N];

		for (int i = 2; i < 8; i++) {
			if (isPrime(i,2)) {
				answer[0] = i;
				makeNum(1, i, bw);
			}
		}

		bw.flush();
		bw.close();
	}
	
	public static void makeNum(int index, int num, BufferedWriter bw) throws IOException {

		if (index == N) {
			bw.write(num + "\n");
			return;
		}

		for (int i = 1; i < 10; i++) {
			int newNum = num * 10 + i;
			if (isPrime(newNum,2)) {
				answer[index] = i;
				makeNum(index + 1, newNum, bw);
			}
		}
	}

}
