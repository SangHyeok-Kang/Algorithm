import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int min = 0;
        int mul = 0;
        for(int i = 1; i < n; i++){
            mul = n % i;
            if(mul == 1){
                answer = i;
                break;
            }
            
        }
        
        return answer;
    }
}