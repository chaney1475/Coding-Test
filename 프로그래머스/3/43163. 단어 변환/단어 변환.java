import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        int answer = 0;
        
        int n = words.length;
        int[] dist = new int[n];
        
        Arrays.fill(dist, -1);
        
        Queue<Integer> q = new LinkedList<>();
        
        int e = -1; // 타겟의 인덱스
        for (int i = 0; i < words.length; i++) {
            
            if (words[i].equals(target)) {
                e = i;
            }
                
            if (check(begin, words[i])) {
                q.add(i);
                dist[i] = 1;
            }
        }
        if (e == -1) return 0;
        
        while(!q.isEmpty()) {
            int node = q.poll();
            
            if (node == e) break;
            for (int i = 0; i < n; i++) {
                if (check(words[i], words[node]) && dist[i] == -1) {
                    dist[i] = dist[node] + 1;
                    q.add(i);
                } 
            }
        }
        
        if (dist[e] == -1) return 0;
        return dist[e];
    }
    
    public boolean check(String a, String b) {
        int cnt = 0;
        
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) cnt++;
        }
        
        if (cnt == a.length() - 1) return true;
        else return false;
    }
}