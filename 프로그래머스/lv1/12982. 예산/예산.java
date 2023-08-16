import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int i = 0;
        int sum = 0;
        Arrays.sort(d);
        
        for(i = 0; i < d.length; i++){
            sum += d[i];
            if(sum <= budget){
                answer++;
            }
        }
        if(sum <= budget){
            answer = d.length;
        }
        return answer;
    }
}