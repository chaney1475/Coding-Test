class Solution {
    public int solution(String s) {
            int answer = s.length();
            int len = s.length();

            //잘랐을때 반복되는 경우 확인
            for (int i = 1; i < len / 2 + 1; i++){
                int cnt = splitString(i, s);
                if (answer > cnt){
                    answer = cnt;
                }
            }
            
            return answer;
    }
    public int splitString(int i, String s){
        int len = s.length() / i;

        if (s.length() % i != 0){
            len += 1;
        }

        String[] temp = new String[len];

        for (int j = 0; j < len; j++) {
            if (j != len - 1) {
                temp[j] = s.substring(i * j, i * (j + 1));
            } else {
                temp[j] = s.substring(i * j);
            }
        }

        return compressString(temp);
    }

    public int compressString(String[] temp){
        int cnt = 1; // 겹치는 문자수
        StringBuilder answer = new StringBuilder();
        int i = 0;
        while (i < temp.length){

            while (i < temp.length - 1 && temp[i].equals(temp[i+1])){
                cnt++;
                i++;
            }
            if (cnt < 2){
                answer.append(temp[i]);
            }else{
                answer.append(cnt).append(temp[i]);
            }
            cnt = 1;
            i++;
        }

        return answer.length();
    }
}