import java.util.*;

class Solution {
    static class Car{
        int w;
        int end;
        Car(int w, int end){
            this.w = w;
            this.end = end;
        }
    }
    public int solution(int bridge, int limit, int[] weights) {
        int answer = 0;

        int idx = 0; //봐야하는 트럭의 순서!
        int N = weights.length;
        
        Queue<Car> q = new LinkedList<>();
        
        int sum = 0;
        int now = 1;
        
        while(idx < N){
            if (q.size() < bridge && sum + weights[idx] <= limit){
                while(q.size() < bridge && idx < N && sum + weights[idx] <= limit){
                    sum += weights[idx];
                    q.add(new Car(weights[idx++], now + bridge));
                    now++;
                }
                
            }else{
                Car car = q.poll();
                sum -= car.w;
                now = Math.max(now, car.end);
            }
        }
        
        while(!q.isEmpty()){
            now = q.poll().end;
        }
        return now;
    }
}