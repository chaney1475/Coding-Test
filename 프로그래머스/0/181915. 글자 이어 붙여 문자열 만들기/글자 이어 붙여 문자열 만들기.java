class Solution {
    public String solution(String my_string, int[] index_list) {
        String[] str = my_string.split("");
        StringBuilder sb = new StringBuilder();
        
        for (int i: index_list){
            sb.append(str[i]);
        }
        return sb.toString();
    }
}