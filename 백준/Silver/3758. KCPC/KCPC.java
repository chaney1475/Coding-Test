import java.util.*;
import java.io.*;

public class Main {
    
  public static void main(String args[]) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int T = Integer.parseInt(br.readLine());
      
      StringBuilder sb = new StringBuilder();
      
      for (int test = 0; test < T; test++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          
          int n = Integer.parseInt(st.nextToken()); // 팀의 갯수
          int k = Integer.parseInt(st.nextToken()); // 문제의 개수
          int t = Integer.parseInt(st.nextToken()); // 팀의 ID
          int m = Integer.parseInt(st.nextToken()); // 로그 엔트리 수
          
          int[][] scores = new int[n + 1][k + 1]; 
          int[] totalScores = new int[n + 1];
          int[] submitCounts = new int[n + 1];
          int[] lastSubmission = new int[n + 1];
          
          for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken());
                int problemId = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                submitCounts[teamId]++;
                lastSubmission[teamId] = i;

                if (scores[teamId][problemId] < score) {
                    totalScores[teamId] += score - scores[teamId][problemId];
                    scores[teamId][problemId] = score;
                }
            }
            
            List<int[]> ranking = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                ranking.add(new int[]{
                    i, // 팀 ID
                    totalScores[i], // 총 점수
                    submitCounts[i], // 제출 횟수
                    lastSubmission[i] // 마지막 제출 시간
                });
            }

            // 정렬
            ranking.sort((a, b) -> {
                if (a[1] != b[1]) return b[1] - a[1]; // 총 점수
                if (a[2] != b[2]) return a[2] - b[2]; // 제출 횟수
                return a[3] - b[3]; // 마지막
            });

            for (int rank = 0; rank < ranking.size(); rank++) {
                if (ranking.get(rank)[0] == t) {
                    sb.append(rank + 1).append("\n");
                    break;
                }
            }
      }
      
      System.out.print(sb);
  }
}
