import java.util.*;
class Solution {
    public int[] solution(int[][] arr) {
        int n = arr.length;
        
        int[] answer = check(arr, 0 , 0, n);
        
        return answer;
    }
    public int[] check(int[][] arr, int a, int b, int n) {
        if (n == 1) {
            if (arr[a][b] == 0) return new int[]{1,0};
            else return new int[] {0,1};
        }
        
        int[] n1 = check(arr, a, b , n / 2);
        int[] n2 = check(arr, a, b + n / 2 , n / 2);
        int[] n3 = check(arr, a + n / 2, b , n / 2);
        int[] n4 = check(arr, a + n  / 2, b + n / 2, n / 2);
        
        if (n1[0] == 1 && n2[0] == 1 && n3[0] == 1 && n4[0] == 1
            && n1[1] == 0 && n2[1] == 0 && n3[1] == 0 && n4[1] == 0
           ) {
            return new int[] {1, 0};
        } else if (n1[1] == 1 && n2[1] == 1 && n3[1] == 1 && n4[1] == 1
                   && n1[0] == 0 && n2[0] == 0 && n3[0] == 0 && n4[0] == 0
                  ) {
            return new int[] {0, 1};
        }
        
        return new int[] {n1[0] + n2[0] + n3[0] + n4[0],
                          n1[1] + n2[1] + n3[1] + n4[1]};
    }
}