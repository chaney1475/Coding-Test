import java.util.*;
// 10초전 10초 후 오프닝 뛰
// prev -10 마이너스면 0으로
// next +10 끝이면 시간 끝
// 오프닝 건너뛰기 <= 현재 <= -> op_end
class Solution {
    static int videoLen;
    static int opStart;
    static int opEnd;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int cur = timeToNum(pos); // 현재 위치
        videoLen = timeToNum(video_len); // 비디오 길이
        opStart = timeToNum(op_start); // 오프닝 시작
        opEnd = timeToNum(op_end); // 오프닝 끝
        
        
        int c_len = commands.length;
        for (int i = 0; i < c_len; i++) {
            
            cur = goOpening(cur);
            String command = commands[i];
            if (command.equals("prev")) {
                cur = getFixed(cur - 10);
            } else {
                cur = getFixed(cur + 10);
            } 
            cur = goOpening(cur);
        }
        
        int min = cur / 60;
        int sec = cur % 60;
        
        String minStr = "";
        String secStr = "";
        if (min / 10 < 1) {
            minStr += "0";
        }
        if (sec / 10 < 1) {
            secStr += "0";
        }
        minStr += min;
        secStr += sec;
        
        answer = minStr + ":" + secStr;
        
        return answer;
    }
    
    public int timeToNum(String str){
        String[] st = str.split(":");
        int min = Integer.valueOf(st[0]);
        int sec = Integer.valueOf(st[1]);
        return min * 60 + sec;
    }
    
    public int getFixed(int cur) {
        if (cur < 0) {
            return 0;
        } else if (cur > videoLen){
            return videoLen;
        } 
        return cur;
    }
    public int goOpening(int cur) {
        if (opStart <= cur && cur <= opEnd) {
            return opEnd;
        }
        return cur;
    }
}