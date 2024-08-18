class Solution {
    public String solution(String s, int n) {
        String answer = "";
        // n만큼 밀자
        // z인 경우에는 a(97)로 , Z인 경우에는 A(65)로
        int length = s.length();
        
        for (int i = 0; i < length; i++){
            char alpha = s.charAt(i);
            if (alpha == ' '){
                answer += " ";
            } else if (alpha >= 97){ 
                answer += (char)((alpha - 97 + n) % 26 + 97); // 소문자인 경우
            } else{
                answer += (char)((alpha - 65 + n) % 26 + 65); // 대문자인 경우
            }
            
            
        }
        
        
        
        return answer;
    }
}