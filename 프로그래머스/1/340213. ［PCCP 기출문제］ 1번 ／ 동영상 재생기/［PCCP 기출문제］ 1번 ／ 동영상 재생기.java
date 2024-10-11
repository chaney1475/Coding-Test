import java.util.*;
import java.io.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int len = getTime(video_len); // 비디오 길이
        int time = getTime(pos); // 현재 위치
        int start = getTime(op_start); //  오프닝 시작
        int end = getTime(op_end); //  오프닝 끝
        
        for (String command : commands) {
            
            if (time >= start && time <= end) {
                time = end; // 오프닝 건너뛰기
            }

            if (command.equals("next")) {
                time += 10;
            } else if (command.equals("prev")) {
                time -= 10;
            }

            // 범위 조정
            if (time < 0) {
                time = 0; // 시작 위치로 조정
            } else if (time >= len) {
                time = len; // 마지막 위치로 조정
            }
        }

        // 마지막으로 오프닝 구간에 있는지 체크
        if (time >= start && time <= end) {
            time = end; // 오프닝 끝으로 이동
        }
        
        String t1 = String.valueOf(time / 60);
        String t2 = String.valueOf(time % 60);
        
        while(t1.length() < 2){
           t1 = "0" + t1; 
        }
        while(t2.length() < 2){
             t2 = "0" + t2; 
        }
        
        return t1 + ":" + t2;

    }
    
    static int getTime(String time){
        String[] s = time.split(":");
        int ans = Integer.parseInt(s[0]);
        ans = ans * 60 + Integer.parseInt(s[1]);
        return ans;
    }
}