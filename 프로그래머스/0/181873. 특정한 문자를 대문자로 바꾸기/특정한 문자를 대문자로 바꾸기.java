class Solution {
    public String solution(String my_string, String alp) {
        String upperCaseAlp = String.valueOf(Character.toUpperCase(alp.charAt(0)));
        return my_string.replace(alp, upperCaseAlp);
    }
}