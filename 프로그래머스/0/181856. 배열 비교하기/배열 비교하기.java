import java.util.Arrays;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        if (arr1.length == arr2.length){
            int a = Arrays.stream(arr1).sum();
            int b = Arrays.stream(arr2).sum();
            if (a == b) {
                return 0;
            } else if (a > b) {
                return 1;
            } else {
                return -1;
            }
        }
        if (arr1.length > arr2.length){
            return 1;
        }
        else{
            return -1;
        }
    }
}