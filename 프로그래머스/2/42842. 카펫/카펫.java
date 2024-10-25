/*
숫자는 무조건 3이상이어야함
2005
-> 1000 * 2000이 됨

가로 길이가 큰거
큰수 작은수

3부터 시작하기

그러면 특정 수까지


브라운이랑 옐로를 더하기 -> 특정 숫자의 곱일것
3이상인 수부터 나누어지는지 확인하기

정답인 a,b
-> 두개 더한 값 (a * b)
-> 브라운 (a * b) - (a -1) * (b-1) 
-> 옐로우 (a -1) * (b-1)
for (int i = 3; i < )
옐로는 두개를 곱한 값인데 항상 1이상이어야함 당연히




*/ 

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int total = brown + yellow;
        
        int big = -1;
        int small = -1;
        
        for (int i = 1; i <= (int) Math.sqrt(yellow); i++){
            if (yellow % i == 0){
                //가능한 조합에 대해서
                int a = i + 2;
                int b = yellow / i + 2;
                
                if (total == a * b){
                    big = b;
                    small = a;
                    break;
                }
            }
        }
        
        int[] answer = {big, small};
        return answer;
    }
}