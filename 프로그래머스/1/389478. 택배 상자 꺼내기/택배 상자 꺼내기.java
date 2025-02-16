import java.util.*;
class Solution {
    
    public int solution(int n, int w, int num) {
        
        int height = (n - 1) / w;
        int left = (n - 1)  % w + 1;
        
        int nowHeight = (num - 1) / w;
        int nowLeft = (num - 1) % w + 1;
        
        int ans = height - nowHeight;
        
        if (height % 2 == nowHeight % 2){
            if (nowLeft <= left) ans++;
        }else{
            if ( nowLeft > (w - left)) ans++;
            
        }
        
        return ans;
    }
//     void make (int height,int left, int n, int w){
//         int nowHeight = (n - 1) / w;
//         int nowLeft = (n - 1) % w + 1;
        
//         int ans = height - nowHeight;
        
//         if (height % 2 == nowHeight % 2){
//             if (nowLeft <= left) ans++;
//         }else{
//             if ( nowLeft > (w - left)) ans++;
            
//         }
        
//         System.out.print(n + " " + ans + " ");
        
        
//     }
}