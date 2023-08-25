import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int zero_count = 0;
        int con_count  = 0;
        
        while(s.length() != 1){
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0') zero_count++;
            }
            s = s.replaceAll("0", "");
            s = Integer.toBinaryString(s.length());
            con_count++;
        }
        
        int[] answer = {con_count, zero_count};
        return answer;
    }
}