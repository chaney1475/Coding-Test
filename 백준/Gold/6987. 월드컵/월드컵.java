import java.util.Scanner;

public class Main {
    
    static int[][] games;
    static boolean isValid;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        for (int t = 0; t < 4; t++) {
        	
            games = new int[6][3];
            boolean total = true;
            for (int i = 0; i < 6; i++) {
                games[i][0] = scanner.nextInt(); // 승리
                games[i][1] = scanner.nextInt(); // 무승부
                games[i][2] = scanner.nextInt(); // 패배
                if(games[i][0] + games[i][1] + games[i][2] != 5) {
                	total = false;
                }
            }
            
            isValid = false;
            dfs(0, 1);
            System.out.print(isValid && total ? "1 " : "0 ");
        }
        scanner.close();
    }

    private static void dfs(int teamA, int teamB) {
        if (isValid) return;
        
        if (teamA == 5) {
            isValid = true;
            return;
        }
        if (teamB == 6) {
            dfs(teamA + 1, teamA + 2);
            return;
        }
        
        if (games[teamA][0] > 0 && games[teamB][2] > 0) {
            games[teamA][0]--;
            games[teamB][2]--;
            dfs(teamA, teamB + 1);
            games[teamA][0]++;
            games[teamB][2]++;
        }

        if (games[teamA][1] > 0 && games[teamB][1] > 0) {
            games[teamA][1]--;
            games[teamB][1]--;
            dfs(teamA, teamB + 1);
            games[teamA][1]++;
            games[teamB][1]++;
        }
        if (games[teamA][2] > 0 && games[teamB][0] > 0) {
            games[teamA][2]--;
            games[teamB][0]--;
            dfs(teamA, teamB + 1);
            games[teamA][2]++;
            games[teamB][0]++;
        }
    }
}
