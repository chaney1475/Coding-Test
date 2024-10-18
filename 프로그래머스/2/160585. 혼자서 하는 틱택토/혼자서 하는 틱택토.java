import java.util.*;
/*

O먼저 X다음
무조건 한줄만 성공해야함

한줄만 성공
O가 이긴 경우 -> o의 갯수가 더 많아야함 1차이 성공한 줄이 한개여야함
X가 이긴 경우 -> o,x 갯수가 같아야함

성공한 줄이 없어야함
비긴 경우 -> o가 5개 x가 4개 여야함

*/

class Solution {
    static char[][] map;
    static int cntO, cntX;
    
    public int solution(String[] board) {
        int answer = -1;
        
        map = new char[3][3];
        
        cntO = 0;
        cntX = 0;
        
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                char tmp = board[i].charAt(j);
                if (tmp == 'O') cntO++;
                else if (tmp == 'X') cntX++;
                map[i][j] = tmp;
            }
        }
        
        return check()? 1 : 0;
    }
    
    static boolean check(){
        
        // for (int i = 0; i < 3; i++)
        //     System.out.println(Arrays.toString(map[i]));
        
//         System.out.println(cntO + " " + cntX);
        
        int lineX = getLines('X');
        int lineO = getLines('O');
        
        
        // System.out.println(lineX + " " + lineO);
        
        if (cntO < cntX) return false;
        if (cntO - cntX > 1) return false;
        
        //이겼는데 진행한 경우
        if (lineX > 0){
            //X가 이긴 경우
            if (lineO > 0) return false;
            if (cntX == cntO) return true;
            else return false;
            
        }else if (lineO > 0){
            //o가 이긴 경우
            if (lineX > 0) return false;
            if (cntX + 1== cntO) return true;
            else return false;
        }
        
        return true;
    }
    
    static int getLines(char now){
        int sum = 0;
        
        for (int i = 0; i < 3; i++){
            if (now == map[i][0] && map[i][0] == map[i][1] && map[i][1] == map[i][2])
                sum++;
        }
        
        for (int i = 0; i < 3; i++){
            if (now == map[0][i] && map[1][i] == map[0][i] && map[1][i] == map[2][i])
                sum++;
        }
        
        if (now == map[0][0] && map[0][0] == map[1][1] && map[1][1] == map[2][2])
            sum++;
        
        if (now == map[2][0] && map[1][1] == map[2][0] && map[1][1] == map[0][2])
            sum++;
        return sum;
    }
}