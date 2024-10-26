import java.util.*;

class Solution {
    static int N = 10000000;
    static boolean[] visited;
    
    static int len;
    static int[] nums;
    static boolean[] notPrime;
    
    static Set<Integer> set;
    
    public int solution(String numbers) {
        int answer = 0;
        
        len = numbers.length();
        nums = new int[len];
        set = new HashSet<>();
        visited = new boolean[len];
        
        for (int i = 0; i < len; i++){
            nums[i] = numbers.charAt(i) - '0';
        }
        
        makePrime();
        
        for (int i = 1; i <= len; i++){
            Arrays.fill(visited, false);
            dfs(0, 0 , i);
        }
        
        return set.size();
    }
    
    static void dfs(int temp, int cnt, int target){
        
        if (cnt == target){
            if (!notPrime[temp]) set.add(temp);
            return;
        }
        
        for (int i = 0; i < len; i++){
            if (visited[i]) continue;
            visited[i] = true;
            dfs(temp * 10 + nums[i], cnt + 1, target);
            visited[i] = false;
        }
        
    }
    
    static void makePrime(){
        
        notPrime = new boolean[N];
        notPrime[0] = true;
        notPrime[1] = true;
        for (int i = 2; i < N; i ++){
            if (notPrime[i]) continue;
            for (int j = i + i; j < N; j += i){
                notPrime[j] = true;
            }
        }
        for (int i = 0; i < N; i++){
            if (notPrime[i]) continue;
        }
    }
}