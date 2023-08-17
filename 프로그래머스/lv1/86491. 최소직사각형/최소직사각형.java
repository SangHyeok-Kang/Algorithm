import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int total_max = 0;
        int total_min = 0;
        for(int i = 0; i < sizes.length; i++){
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);
            
            total_max = Math.max(total_max, max);
            total_min = Math.max(total_min, min);        
        }
       
        answer = total_max*total_min;
        return answer;
    }
}