import java.util.*;
import java.io.*;

public class Main {
    
    static int[] teamCnt;
    
    static int[] teamCntForSum;
    
    static int[] team;
    static int [] teamTotal;
    static int [] teamFifth;
    
    static int N;
    
    static int winningTeam;
    static int winningNum;
    
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        
        for (int t = 0; t < T; t++){
            
            teamCnt = new int[201]; // 각 팀이 몇명 있는지
            
            teamTotal = new int[201]; // 각 팀의 합산 점수
            
            teamFifth = new int[201];
            
            
            teamCntForSum = new int[201];
            
            int maxTeam = 0;
            
            winningNum = Integer.MAX_VALUE;
            winningTeam = 0;
            
            N = Integer.parseInt(br.readLine());
            
            team = new int[N];
            
            st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < N; i++){
                int teamNum = Integer.parseInt(st.nextToken());
                
                maxTeam = Math.max(teamNum, maxTeam); // 무슨 팀까지 있는지
                
                team[i] = teamNum; // 각각 무슨 팀인지
                teamCnt[teamNum]++; // 몇명인지
                
            }
            
            int n = 1;
            for (int i = 0; i < N; i++){
                if (teamCnt[team[i]] < 6) continue; // 팀의 사람이 6보다 적으면 무시
                
                if (teamCntForSum[team[i]] < 4){
                    teamTotal[team[i]] += n;
                }else if(teamCntForSum[team[i]] == 4){
                    teamFifth[team[i]] = n;
                }
                n++;
                teamCntForSum[team[i]]++;
            }
            
            for (int i = 1; i <= maxTeam; i++){
            if (teamCnt[i] < 6) continue; // 6명 보다 적으면 패스
            
            if (teamTotal[i] < winningNum){
                winningNum = teamTotal[i]; // 점수 갱신
                winningTeam = i; // 팀 갱신
                
            }else if (teamTotal[i] == winningNum){
                if (teamFifth[i] < teamFifth[winningTeam]){
                    winningNum = teamTotal[i]; 
                    winningTeam = i;
                }
            }
            
            
            }
            
            System.out.println(winningTeam);
            
        }
        
    }
}