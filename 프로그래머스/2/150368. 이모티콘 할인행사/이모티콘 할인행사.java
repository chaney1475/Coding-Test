import java.util.*;

class Solution {
    int[] emo;
    int[][] users;
    
    // 실제 이모티콘에 적용된 퍼센테이지
    int[] percent;
    
    int[] candi; // 퍼센트 후보군
    int n; // 이모티콘 길이
    
    int buyer;
    int total;
    public int[] solution(int[][] users, int[] emoticons) {
        emo = emoticons;
        this.users = users;
        n = emoticons.length;
        percent = new int[n];
        
        candi = new int[]{10,20,30,40};
        
        dfs(0);
        
        int[] answer = new int[]{buyer, total};
        return answer;
    }
    
    public void dfs(int now) {
        // 현재 몇번째 이모티콘을 할인해야하는지 
        
        if (now == n) {
            int tmpBuyer = 0;
            int tmpTotal = 0;
            
            // 각 사람을 돌면서
            for (int i = 0; i < users.length; i++) {
                int sum = 0;
                
                int per = users[i][0];
                int limit = users[i][1];
                
                // 이모티콘을 계산
                for (int e = 0; e < n; e++) {
                    if (percent[e] >= per) {
                        sum += emo[e] * (100 - percent[e]) / 100;
                    }
                }
                if (sum >= limit) {
                    tmpBuyer++;
                } else {
                    tmpTotal += sum;
                }
            }
            
            if (tmpBuyer > buyer) {
                buyer = tmpBuyer;
                total = tmpTotal;
            } else if (tmpBuyer == buyer) {
                total = Math.max(total, tmpTotal);
            }
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            percent[now] = candi[i];
            dfs(now + 1);
        }

    }
}