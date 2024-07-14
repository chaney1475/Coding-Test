class Solution {
    public int solution(int[] num_list) {
        
        StringBuilder oddBuilder = new StringBuilder();
        StringBuilder evenBuilder = new StringBuilder();
        
        for (int num : num_list) {
            if (num % 2 == 0) {
                evenBuilder.append(num);
            } else {
                oddBuilder.append(num);
            }
        }
        
        int oddNumber = Integer.valueOf(oddBuilder.toString());
        int evenNumber = Integer.valueOf(evenBuilder.toString());
        
        return oddNumber + evenNumber;
    }
}