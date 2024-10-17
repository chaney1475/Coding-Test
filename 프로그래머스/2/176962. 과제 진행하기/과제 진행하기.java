import java.util.*;

class Solution {
    static class Study{
        String name;
        int leftD;
        Study(String name, int leftD){
            this.name = name;
            this.leftD = leftD;
        }
    }
    public String[] solution(String[][] plans) {
        int N = plans.length;
        
        String[] answer = new String[N];
        List<String> list = new ArrayList<>();
        
        Arrays.sort(plans, (a,b) -> {
           int aTime = makeInt(a[1]);
            int bTime = makeInt(b[1]);
            return(aTime-bTime);
        });
        
        Deque<Study> dq = new ArrayDeque<>();
        
        for (int i = 0; i < N ; i++){
            String[] now = plans[i];
            
            String name = now[0];
            int start = makeInt(now[1]);
            int duration = Integer.parseInt(now[2]);
            
            // System.out.println(name + " " + start + " " + duration);
            //다음걸 보아야함
            if( i == N - 1 ){
                list.add(name);
                break;
            }
            String[] next = plans[i + 1];
            int nextStart = makeInt(next[1]);
            // System.out.println("next : " + nextStart);
            //내가 끝나는 시간이랑 nextStart 비교
            
            if (nextStart == start + duration){
                //시간이 딱맞는 경우
                list.add(name);//정답에 현재 이름 넣기
            }else if (nextStart > start + duration){
                //현재꺼를 진행 시키고 나서도 시간이 남음
                list.add(name);
                int left = nextStart - (start + duration);
                
                while(!dq.isEmpty() && left > 0){
                    int nextLeft = dq.peekLast().leftD;
                    //nextLeft가 처리 가능한지 판별
                    if(nextLeft <= left){
                        left -= nextLeft;
                        Study tmp = dq.pollLast();
                        list.add(tmp.name);
                    }else{
                        dq.peekLast().leftD -= left;
                        left = 0;
                    }
                }
                
            }else{
                //진행하다가 중단해야하는 경우
                int leftD = duration - (nextStart - start);
                dq.addLast(new Study(name, leftD));
            }
            
        }
        while(!dq.isEmpty()){
            list.add(dq.pollLast().name);
        }
        
        return list.toArray(new String[0]);
    }
                
    static int makeInt(String time){
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
}