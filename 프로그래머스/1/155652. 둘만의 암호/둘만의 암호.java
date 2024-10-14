import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        char[] ans = new char[] {'a','b','c','d','e','f','g','h','i'
            ,'j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        
        List<Integer> alpha = new ArrayList<>();
        for (int i = 0; i < 26; i++){
            alpha.add(i);
        }
        
        for (int i = 0; i < skip.length(); i++){
            alpha.remove(new Integer(skip.charAt(i) - 'a'));
        }
        
        for (Integer i : alpha){
            System.out.print(ans[i] + " ");
        }
        
        //index만큼 더한다
        
        StringBuilder sb = new StringBuilder();
        int len = alpha.size();
        
        //사이즈만큼 돌아감!
        for (int i = 0; i < s.length(); i++){
            
            int now = alpha.indexOf(s.charAt(i) - 'a');
            // System.out.println("now : " + now);
            int next = (now + index) % len;
            
            // System.out.println("next : " + next);
            
            sb.append(ans[alpha.get(next)]); //인덱스 값 가져오기
        }
        
        System.out.println(sb);
        
        return sb.toString();
    }
}