import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        //같아지는 경우 cnt++;
        char x = 'A';
        
        int xCnt = 0; //맨 앞에 있는 문자의 갯수
        int yCnt = 0; // 다르게 되는 문자의 갯수
        
        for (int i = 0; i < s.length(); i++){
            
            if(xCnt == 0 && 0 == yCnt){
                x = s.charAt(i);
            }
            
            if(s.charAt(i) == x){
                xCnt++;
            }else{
                yCnt++;
            }
            
            //갯수를 세고나서 같으면 또 뒤에보기
            if(xCnt == yCnt && xCnt != 0){
                xCnt = 0;
                yCnt = 0;
                answer++;
            }
        }
        
        if(xCnt != yCnt){
            answer++;
        }
        
        return answer;
    }
}