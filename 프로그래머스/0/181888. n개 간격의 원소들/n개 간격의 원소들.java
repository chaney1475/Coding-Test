class Solution {
    public int[] solution(int[] num_list, int n) {
        int lenn = (num_list.length + n - 1) / n;
        int[] answer = new int[lenn];
        for(int i = 0; i < num_list.length ; i += n){
            answer[i / n] = num_list[i];
        }
        return answer;
    }
}