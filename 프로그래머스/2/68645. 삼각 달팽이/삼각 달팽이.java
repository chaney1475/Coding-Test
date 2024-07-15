class Solution {
    public int[] solution(int n) {
        
		int size = (n+1) * n /2;
        int[] answer = new int[size];
        
        //실제 값을 저장할 2차원 배열
        int[][] temp = new int[n][n];
        
        //시작 위치
        int x = -1;
        int y = 0;
        
        // 방향 flag x++, y++, x-- y--
        int flag = 0;
        
        int num = 1;
        
        // 한변의 길이 시작 n-i
        for(int i = n; i > 0; i--) {
        	for(int j = 1; j < i+1; j++) {
        		if(flag == 0) {
            		x++;
            	} else if(flag == 1) {
            		y++;
            	}else {
            		x--;
            		y--;
            	}
        		temp[x][y] = num++;
    		}
        	flag = (flag + 1) % 3;
        }
        

        int index = 0;
        for(int[] arr : temp) {
        	for (int t : arr) {
        		if (t != 0) {
        			answer[index++] = t;
        		}
        		
        	}
        }
        return answer;
        
    }
}