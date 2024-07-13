import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        String[] answer = {};
        
         List<String> unfinishedTasks = new ArrayList<>();
        
        // todo_list와 finished 배열을 순회하면서 작업이 끝나지 않은 일들을 추가
        for (int i = 0; i < todo_list.length; i++) {
            if (!finished[i]) {
                unfinishedTasks.add(todo_list[i]);
            }
        }
        
        return unfinishedTasks.toArray(new String[0]);
    }
}