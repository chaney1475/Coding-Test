class Solution {
    public int[] solution(int[] num_list) {
        int length = num_list.length;
        int last = num_list[length - 1];
        int secondLast = num_list[length - 2];
        int newElement;

        if (last > secondLast) {
            newElement = last - secondLast;
        } else {
            newElement = last * 2;
        }

        // 새로운 배열을 생성하고 기존 배열의 원소를 복사한 후, 새로운 원소를 추가합니다.
        int[] answer = new int[length + 1];
        System.arraycopy(num_list, 0, answer, 0, length);
        answer[length] = newElement;
        
        return answer;
    }
}