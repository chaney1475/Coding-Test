class Solution {
    public int solution(int[] num_list) {
        int length = num_list.length;
        int result;

        if (length >= 11) {
            result = 0;
            for (int num : num_list) {
                result += num;
            }
        } else {
            result = 1;
            for (int num : num_list) {
                result *= num;
            }
        }

        return result;
    }
}