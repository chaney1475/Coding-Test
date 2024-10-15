import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        Deque<Character> stack = new ArrayDeque<>();
        int totalPieces = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                
                if (input.charAt(i - 1) == '(') {
                    totalPieces += stack.size();
                } else {
                    totalPieces++;
                }
            }
        }

        System.out.println(totalPieces);
    }
}
