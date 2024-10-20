import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        //박스 상자의 숫자를 뜻하는 i는 1부터 N까지
        
        int box = 1;
        int N = order.length;
        
        
        for (int i = 0; i < N; i++){
            int nowNum = order[i];
//             System.out.println("이게 나와야함 : " + nowNum);
            
//             System.out.println("스택 : " + dq);
            
            while (nowNum >= box){
                dq.addLast(box++);
            }
            
            // System.out.println("스택에 넣어주고서 : " + dq);
            
            if (!dq.isEmpty() && nowNum == dq.peekLast()){
                //현재 번호가 스택에 있는 경우
                dq.pollLast();
                answer++;
            }else{
                break;
            }
            
            // System.out.println("스택에서 빼주고나서 : " + dq);
        }
        
        
        
        return answer;
    }
}