/*

무조건 가능하다??
항공권을 모두 사용한다 -> dfs로? 

일단 방문한 곳은 방문 안하는게 맞나? -> 
1000개인경우...흠.....
간선을 고르기??
-> 가장 빠른 간선을 매번 고른다
남는 간성 중에 앞에서부터 고르기
앞에서부터 읽는데 나의 도착지에서 출발하면 고르기

*/
import java.util.*;

class Solution {
    static int N;
    static boolean[] visited;
    static String[] temp;
    
    static List<Tic> list;
    static boolean flag;
    
    static String[] ans;
    
    static class Tic{
        String start, end;
        Tic(String start, String end){
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString(){
            return "[" + start + ", " + end + "]";
        }
    }
    
    public String[] solution(String[][] tickets) {
        
        N = tickets.length;
        visited = new boolean[N];
        
        list = new ArrayList<>();
        
        for (int i = 0; i < N; i++){
            list.add(new Tic(tickets[i][0], tickets[i][1]));
        }
        //끝나는 곳이 먼저로 배열
        Collections.sort(list, (a,b) -> {
           return a.end.compareTo(b.end); 
        });
        
        System.out.println(list);
        //정답을 담은 배열
        
        temp = new String[N + 1];
        ans = new String[N+1];
        
        temp[0] = "ICN";
        
        for (int i = 0; i < N; i++){
            if (flag) break; // 나왔으면 브레이크
            if (list.get(i).start.equals("ICN")){
                visited[i] = true;
                temp[1] = list.get(i).end;
                dfs(list.get(i).end, 2);
                visited[i] = false;
            }
        }
        
        
        return ans;
    }
    
    static void dfs(String now, int cnt){
        
        if (flag) return;
        
        if (cnt == N + 1){
            System.arraycopy(temp, 0, ans, 0, N + 1);
            flag = true;
            return;
        }
        
        for (int i = 0; i < N; i++){
            if(visited[i]) continue;
            if (now.equals(list.get(i).start)){
                visited[i] = true;
                temp[cnt] = list.get(i).end;
                dfs(list.get(i).end, cnt+1);
                visited[i] = false;
                
            }
        }
        
    }
    
}