import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        int N = book_time.length;
        int[][] books = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            books[i][0] = makeTime(book_time[i][0]);
            books[i][1] = makeTime(book_time[i][1]);
        }
        
        Arrays.sort(books, (a,b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        int answer = 0;
        
        for (int i = 0; i < N; i++) {
            int[] cur = books[i];
            int in = cur[0];
            int out = cur[1];
            
            // 현재 있는 것들 중에 나보다 시간이 더 작은 거 있으면
            if (!q.isEmpty() && q.peek() <= in) {
                q.poll();
            }
            
            q.add(out +  10);
            answer = Math.max(q.size(), answer);
        }
        
        return answer;
    }
    
    public int makeTime(String s) {
        String[] str = s.split(":");
        int h = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        
        return h * 60 + m;
    }
}