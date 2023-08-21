import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int min = 0;
        int max = 0;
        String[] str_num = s.split("\\s");
        int[] num = new int[str_num.length];
        
        for (int i = 0; i < str_num.length; i++) {
            num[i] = Integer.parseInt(str_num[i]);
        }
       
        min = num[0];
        max = num[0];
        
        for(int i = 0; i < num.length; i++){
            max = Math.max(max, num[i]);
            min = Math.min(min, num[i]);
            System.out.println(min);
        }
        answer = Integer.toString(min) + " " + Integer.toString(max);
        return answer;
        
    }
}