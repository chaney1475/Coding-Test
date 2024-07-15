class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        
        return aa(ineq, eq, n, m) ? 1 : 0 ;
    }
    public boolean aa(String ineq, String eq, int n, int m){
        if(ineq.equals(">")){
            if(eq.equals("=")){
                return (n >= m);
            }else{
                return (n > m);
            }
        }else{
            if(eq.equals("=")){
                return (n <= m);
            }else{
                return (n < m);
            }
        }
    }
}