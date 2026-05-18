import java.util.*;

class Solution {
    int len;
    int[] picked, ans;
    int N;
    int answer;
    Set<Integer>[] sets;
    
    public int solution(int n, int[][] q, int[] ans) {
        
        answer = 0;
        len = q.length;
        N = n;
        this.ans = ans;
        
        sets = new HashSet[len];
        picked = new int[5]; // 5개 고르기
        
        for (int i = 0; i < len; i++) {
            sets[i] = new HashSet<>();
            for (int j = 0; j < 5; j++) {
                sets[i].add(q[i][j]);
            }
        }
        
        dfs(0, 0); // 현재 무슨 숫자를 고를건지
        
        return answer;
    }
    public void dfs(int idx, int before) {
        if (idx == 5) {
            if (check()) answer++;
            return;
        }
        
        for (int i = before + 1; i <= N; i++) {
            picked[idx] = i;
            dfs(idx + 1, i);
        }
    }
    
    public boolean check() {
        for (int j = 0; j < len; j++) {
            int cnt = 0;
            
            for (int i = 0; i < 5; i++) {
                if (sets[j].contains(picked[i])) cnt++;
            }
            
            if (cnt != ans[j]) return false;
        }
        return true;
    }
}
