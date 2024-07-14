class Solution {
    public int[] solution(int n, int k) {
        int sizze = n/k;
        
        int[] answer = new int[sizze];
        
        for (int i = 1; i <= sizze; i ++){
            answer[i-1] = k * i;
        }
        
        return answer;
    }
}