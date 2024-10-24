/*
각 위치에서 변할 수 있는 단어들이 정해져있음
비교를 해서 한개 차이가 나면 거기로 갈 수 있도록?
나왔던 단어는 방문 불가능
dfs로?

*/

class Solution {
    static int len; // 단어의 길이
    static int N; // 단어 갯수
    
    static boolean[] temp;
    
    static int ans;
    static String[] word;
    static String tar;
    
    public int solution(String begin, String target, String[] words) {
        len = words[0].length();
        word = words;
        
        ans = Integer.MAX_VALUE;
        N = words.length;
        tar = target;
        
        temp = new boolean[N];
        
        dfs(begin, 0);
        
        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }
    
    static void dfs(String now, int cnt){
        
        if (cnt > ans) return;
        
        if (now.equals(tar)) {
            ans = Math.min(ans, cnt);
            return;
        }
        
        for (int i = 0; i < N; i++){
            if (canChange(now, word[i]) && !temp[i]) {
                temp[i] = true;
                dfs(word[i], cnt + 1);
                temp[i] = false;
            }
        }
    }
    
    static boolean canChange(String a, String b){
        
        int cnt = 0;
        for (int i = 0; i < len; i++){
            if (a.charAt(i) != b.charAt(i)){
                cnt++;
                if (cnt > 2) return false;
            }
        }
        if (cnt == 1) return true;
        else return false;
    }
}