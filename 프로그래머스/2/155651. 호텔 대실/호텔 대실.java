import java.util.*;

class Solution {
    static boolean[] visited;
    static int N;
    
    
    public int solution(String[][] book_time) {
        int ans = 0;
        N = book_time.length;
        visited = new boolean[N];
        int[][] list = new int [N][2];
        
        for (int  i = 0; i < N; i++){
            int start = makeInt(book_time[i][0]);
            int end = makeInt(book_time[i][1]);
            list[i] = new int[] {start, end};
        }
        
        Arrays.sort(list, (a,b) -> {
            if (a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            }else{
                return Integer.compare(a[1], b[1]);
            }
        });
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++){
            int[] now = list[i];
            
            int start = now[0];
            int end = now[1] + 10; // 끝나는 시간 
            
            if (!q.isEmpty() && q.peek() <= start){
                q.poll();
            }
            
            q.add(end);
            
        }
        
        return q.size();
    }
    
    
    static int makeInt(String s){
        String[] t = s.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}