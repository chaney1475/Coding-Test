class Solution {
    public int[] solution(int[] answer) {
        for (int i = 0; i < answer.length; i++){
            if (answer[i] < 50 && answer[i] % 2 == 1){
                answer[i] = answer[i] * 2;
            }
            else if (answer[i] >= 50 && answer[i] % 2 == 0){
                answer[i] = answer[i] /2;
            }
        }
        return answer;
    }
}