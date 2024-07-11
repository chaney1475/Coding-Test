class Solution {
    public String[] solution(String[] strArr) {
        // 결과를 저장할 배열을 생성
        String[] answer = new String[strArr.length];

        // 배열을 순회하면서 홀수/짝수 인덱스를 처리
        for (int i = 0; i < strArr.length; i++) {
            if (i % 2 == 0) {
                // 짝수 인덱스는 소문자로 변환
                answer[i] = strArr[i].toLowerCase();
            } else {
                // 홀수 인덱스는 대문자로 변환
                answer[i] = strArr[i].toUpperCase();
            }
        }

        return answer;
    }
}