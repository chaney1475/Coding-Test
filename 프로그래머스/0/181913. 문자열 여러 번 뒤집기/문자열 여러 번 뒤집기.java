class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        
        int n = queries.length;
        char[] arr = my_string.toCharArray();
        
        for (int i = 0; i < n; i++){
            int s = queries[i][0];
            int e = queries[i][1];
            
            while(s < e){
                char q = arr[e];
                arr[e] = arr[s];
                arr[s] = q;
                s++;
                e--;
            }
        }
        answer = new String(arr);
        return answer;
    }
}