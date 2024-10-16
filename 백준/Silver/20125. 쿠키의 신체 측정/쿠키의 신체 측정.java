import java.util.*;
import java.awt.HeadlessException;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int N = Integer.parseInt(br.readLine());
		
		char[][] map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		
		int heartX = -1;
		int heartY = -1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '*') {
					int cnt = 0;
					
					for (int d = 0; d < 4; d++) {
						int nx = dx[d] + i;
						int ny = dy[d] + j;
						
						if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == '*') {
							cnt++;
						}
					}
					if(cnt == 4) {
						heartX = i;
						heartY = j;
						break;
					}
				}
			}
		}
		
		//팔
		int leftArm = 1;
		int rightArm = 1;
		
		int waist = 1;
		
		int leftLeg = 0;
		int rightLeg = 0;
		
		while( heartY - 1 - leftArm >= 0 && map[heartX][heartY - leftArm - 1] == '*') {
			leftArm++;
		}

		while(rightArm + heartY + 1 < N && map[heartX][rightArm + heartY + 1] == '*') {
			rightArm++;
		}
		
		while(waist + heartX + 1 < N && map[heartX + waist + 1][heartY] == '*') {
			waist++;
		}
		int heartXori = heartX;
		heartX += waist;
		
		while(leftLeg + heartX + 1 < N && map[heartX + leftLeg + 1][heartY - 1] == '*') {
			leftLeg++;
		}
		while(rightLeg + heartX + 1 < N && map[heartX + rightLeg + 1][heartY + 1] == '*') {
			rightLeg++;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(heartXori + 1).append(" ").append(heartY + 1).append("\n");
		sb.append(leftArm).append(" ").append(rightArm).append(" ")
		.append(waist).append(" ")
		.append(leftLeg).append(" ").append(rightLeg);
		
		System.out.println(sb);
		
	}
}