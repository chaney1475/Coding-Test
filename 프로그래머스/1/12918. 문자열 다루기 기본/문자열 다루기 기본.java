class Solution {
    public boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6){
            for (int i = 0; i < s.length(); i++){
                if (Character.isAlphabetic(s.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}