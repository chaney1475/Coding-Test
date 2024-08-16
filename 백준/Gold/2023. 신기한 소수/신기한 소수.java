import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;

	static boolean isPrime(int n, int i) {
        if (n <= 1) {
            return false;
        }
        if (i * i > n) {
            return true;
        }
        if (n % i == 0) {
            return false;
        }
        return isPrime(n, i + 1);
    }

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = sc.nextInt();


		for (int i = 2; i < 8; i++) {
			if (isPrime(i,2)) {
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

		for (int i = 1; i < 10; i+=2) {
			int newNum = num * 10 + i;
			if (isPrime(newNum,2)) {
				makeNum(index + 1, newNum, bw);
			}
		}
	}

}
