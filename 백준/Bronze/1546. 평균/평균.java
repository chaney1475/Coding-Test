import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int N = sc.nextInt();

        long sum = 0;
        long max = 0;

        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            sum += temp;
            if (temp > max) max = temp;
        }

        System.out.print(sum*100.0/max/N);
    }
}