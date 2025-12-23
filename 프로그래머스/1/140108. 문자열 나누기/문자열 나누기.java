class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        int xCnt = 0;
        int yCnt = 0;
        
        char first = s.charAt(0);
        
        for (int i = 0; i < n; i++){
            char cur = s.charAt(i);
            if (
                xCnt == 0 &&
                yCnt == 0){
                first = cur;
            }
            if (cur == first){
                xCnt++;
            }else{
                yCnt++;
            }
            if(xCnt == yCnt){
                answer++;
                xCnt = 0;
                yCnt = 0;
            }
        }
        
        if (xCnt > 0 || yCnt > 0){
            answer++;
        }
        
        return answer;
    }
}