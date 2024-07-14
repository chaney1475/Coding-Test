class Solution {
    public int solution(int[] num_list) {
        int a1 = 0;
        int a2 = 1;
        for (int n : num_list){
            a1 += n;
            a2 *= n;
        }
        a1 = a1 * a1;
        return a1 > a2 ? 1 : 0; 
    }
}