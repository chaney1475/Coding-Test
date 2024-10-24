import java.util.*;

class Solution {
    static class Car{
        int in;
        int out = 1439;
        Car(int in){
            this.in = in;
        }
        Car(){
        }
        @Override
        public String toString(){
            return "[" + in + ", " + out + "] ";
        }
    }
    static Map<Integer, Car> cars;
    static Map<Integer, Integer> fee;
    
    static int N;
    
    public int[] solution(int[] fees, String[] records) {
        cars = new HashMap<>();
        fee = new HashMap<>();
        
        N = records.length;
        
        for (int i = 0; i < N; i++){
            String[] now = records[i].split(" ");
            
            int time = makeInt(now[0]);
            int num = Integer.parseInt(now[1]);
            
            if (cars.containsKey(num)){
                cars.get(num).out = time;
                //나간 시점!
                Car car = cars.get(num);
                fee.put(num, fee.getOrDefault(num, 0) + car.out - car.in);
                
                cars.remove(num);
            }else{
                cars.put(num, new Car(time));
            }
        }
        
        for (Map.Entry<Integer,Car> l : cars.entrySet()){
            Car car = l.getValue();
            fee.put(l.getKey(), fee.getOrDefault(l.getKey(), 0) + car.out - car.in);
        }
        Set<Map.Entry<Integer,Integer>> set = fee.entrySet();
        
        List<int[]> ans = new ArrayList<>();
        
        for (Map.Entry<Integer,Integer> now : fee.entrySet()){
            int times = now.getValue();
            //기본 시간 빼고 남은거는 곱하기해서 더하기
            int sum = 0;
            sum += fees[1];
            if (times - fees[0] > 0){
                int mul = (times - fees[0]) / fees[2];
                if ((times - fees[0]) % fees[2] != 0) mul++;
                sum += mul * fees[3];
            }
            ans.add(new int[]{now.getKey(), sum});
        }
        
        Collections.sort(ans,(a,b) -> a[0] - b[0]);
        
        int[] answer = new int[ans.size()];
        int idx = 0;
        for (int[] c : ans){
            answer[idx++] = c[1];
        }
        
        return answer;
    }
    
    static int makeInt(String s){
        String[] t = s.split(":");
        return Integer.parseInt(t[1]) + Integer.parseInt(t[0])  * 60;
    }
}