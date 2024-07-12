class Solution {
    public int solution(int[] numbers, int com) {
        int answer = 0;
        for (int n : numbers){
            answer += n;
            if (answer > com) {
                return answer;
            }
        }
        return answer;
        
        
    }
}