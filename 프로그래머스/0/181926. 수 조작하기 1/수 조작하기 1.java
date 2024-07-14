class Solution {
    public int solution(int n, String control) {
        String[] str = control.split("");
        for (String s: str){
            if(s.equals("w")){
                n+=1;
            }else if(s.equals("s")){
                n-=1;
            }else if(s.equals("d")){
                n+=10;
            }else{
                n-=10;
            }
        }
        return n;
    }
}