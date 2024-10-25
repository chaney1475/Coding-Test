import java.util.*;

class Solution {
    
    static class Job{
        int start, end, duration;
        Job(int start, int end, int duration){
            this.start = start; this.end = end; this.duration = duration;
        }
        // @Override
        // public String toString(){
        //     return start + " " + end + " | ";
        // }
    }
    
    public int solution(int[][] jobs) {
        
        List<Job> list = new ArrayList<>();
        
        int N = jobs.length;
        
        int time = 0;
        
        for (int i = 0; i < N ; i++){
            int[] now = jobs[i];
            list.add(new Job(now[0], now[0] + now[1], now[1]));
        }
        
        Collections.sort(list, (a,b) -> {
            if (a.start != b.start){
                return a.start - b.start;
            }else{
                return a.end - b.end;
            }
        });
        
        PriorityQueue<Job> q = new PriorityQueue<>((a,b) -> a.duration - b.duration);
        
        int idx = 0;
        
        int sum = 0;
        
        while (idx < N){
            
            //현재 시간이전에 들어온 애들은 큐에 넣어준다
            
            while (idx < N && list.get(idx).start <= time){
                q.add(list.get(idx++));
            }
            
            //없는 경우에는 현재 봐야하는 거에서 꺼내기!
            if(q.isEmpty()){
                Job now = list.get(idx++);
                time = now.end;
                sum += (time - now.start);
            }else{
                //큐에 있는 경우에는 맨 앞 뽑기
                Job now = q.poll();
                //현재 시간에다가 이 작업의 걸리는 시간 더하기
                time += now.duration;
                sum += (time - now.start);
            }
        }
        
        while(!q.isEmpty()){
            Job now = q.poll();
            time += now.duration;
            sum += (time - now.start);
        }
        
        System.out.println(sum);
        
        return sum / N;
    }
}