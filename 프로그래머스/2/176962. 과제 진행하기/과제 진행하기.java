import java.util.*;

class Solution {
    class Study{
        int start, end, duration; String name;
        Study(String name, int start, int duration){
            this.start = start;
            this.name = name; this.duration = duration;
        }
        public String toString(){
            return "s: " + start + ", d: " + duration + " n: "+ name;
        }
    }
    public String[] solution(String[][] plans) {
        int N = plans.length;
        
        Study[] q = new Study[N];
        int qi = 0;
        // 시작시간이 빠른 순으로
        LinkedList<Study> left = new LinkedList<>();
        
        for (String[] p : plans){
            String name = p[0];
            int start = make(p[1]);
            int duration = Integer.valueOf(p[2]);
            q[qi++] = new Study(name, start, duration);
        }
        
        String[] answer = new String[N];
        int idx = 0;
        
        Arrays.sort(q, (a,b) -> a.start - b.start);
        
        for (int i = 0; i < N ; i++){
            
            int start = q[i].start;
            int duration = q[i].duration;
            String name = q[i].name;
            Study now = q[i];
            
            if (i == N - 1){
                answer[idx++] = name;
                break;
            }
            
            int nextStart = q[i + 1].start;
            
            if (nextStart == start + duration){
                answer[idx++] = name;
            }else if (nextStart > start + duration){
                answer[idx++] = name;
                int leftTime = nextStart - (start + duration);
                
                while (!left.isEmpty() && leftTime > 0){
                    int nextTime= left.peekLast().duration;
                    
                    if (nextTime <= leftTime){
                        leftTime -= nextTime;
                        answer[idx++] = left.pollLast().name;
                    }else{
                        left.peekLast().duration -= leftTime;
                        leftTime = 0;
                    }
                }
                
            }else{
                now.duration -= nextStart - start;
                left.addLast(now);
            }
            
        }
        
        while (!left.isEmpty()){
            Study now = left.pollLast();
            answer[idx++] = now.name;
        }
        
        return answer;
    }
    
    int make(String time){
        String[] tmp = time.split(":");
        int h = Integer.valueOf(tmp[0]);
        int m = Integer.valueOf(tmp[1]);
        return h * 60 + m;
    }
    
    
}