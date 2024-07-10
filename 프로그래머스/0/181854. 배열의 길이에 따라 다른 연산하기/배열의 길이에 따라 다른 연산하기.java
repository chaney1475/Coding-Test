import java.util.*;
class Solution {
    public int[] solution(int[] arr, int n) {
        int[] answer = {};
        //arr의 길이가 홀수 일때 짝수 인덱스에 n 더하기
        //짝수일때 홀수 인덱스에 n 더하기
        int start;
        if (arr.length % 2 == 0){
            start = 1;
        }else{
            start = 0;
        }
        for (int i = start; i < arr.length; i+=2){
            arr[i] += n;
        }
        return arr;
    
    }
}