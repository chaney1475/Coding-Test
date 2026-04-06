import java.util.*;

class Solution {
    
    class Info {
        int dur;
        int start;
        String name;
        String target;

        public Info(int dur, int start, String name, String target) {
            this.dur = dur;
            this.start = start;
            this.name = name;
            this.target = target;
        }
    }
    
    public String solution(String m, String[] musicinfos) {
        
        m = convert(m); // # 처리
        
        int N = musicinfos.length;
        
        List<Info> infos = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String[] info = musicinfos[i].split(",");
            
            int start = getTime(info[0]);
            int end = getTime(info[1]);
            
            String name = info[2];
            String song = convert(info[3]); // # 처리
            
            int dur = end - start;
            
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < dur; j++) {
                sb.append(song.charAt(j % song.length()));
            }
            
            String target = sb.toString();
            
            infos.add(new Info(dur, start, name, target));
        }
        
        // 재생시간 긴 순 → 먼저 입력된 순
        infos.sort((a, b) -> {
            if (a.dur != b.dur) {
                return b.dur - a.dur;
            }
            return a.start - b.start;
        });
        
        for (Info info : infos) {
            if (info.target.contains(m)) {
                return info.name;
            }
        }
        
        return "(None)";
    }
    
    public int getTime(String str) {
        String[] cur = str.split(":");
        int hour = Integer.valueOf(cur[0]);
        int min = Integer.valueOf(cur[1]);
        return hour * 60 + min;
    }
    
    // # 처리
    public String convert(String s) {
        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }
}