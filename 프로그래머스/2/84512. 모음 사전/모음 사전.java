import java.util.*;

class Solution {
    
    int count, answer = 0;
    char[] arr;
    char[] list = new char[]{'A', 'E','I','O','U'};
    String word;
    
    
    public int solution(String word) {
        this.word = word;
        
        arr = new char[5];
        Arrays.fill(arr, ' ');
        
        dfs(-1);
        
        return answer;
    }
    
    public void dfs(int idx) {
        
        if (answer != 0) return;
        
        if(idx >= 0) count++;
        
        int tmp = 0;
        
        for (int i = 0; i < Math.min(word.length(), 5); i++) {
            if (word.charAt(i) == arr[i]) tmp++;
            else break;
        }
        
        if (tmp == word.length()) {
            answer = count;
            return;
        }
        
        if (idx == 4) return;
        
        for (int i = 0; i < 5; i++) {
            arr[idx + 1] = list[i];
            dfs(idx + 1);
            arr[idx + 1] = ' ';
        }
        
    }
}