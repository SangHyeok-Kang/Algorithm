import java.util.*;

class Solution {
    private int countZero(String s){
        int zero = 0;
        for(char c : s.toCharArray()){
            if(c == '0') zero++;
        }
        
        return zero;
        
    }
    public int[] solution(String s) {
        int loop = 0; //2진 변환 횟수
        int removed = 0; //총 0 제거 개수
        
        while(!s.equals("1")){
            int zeros = countZero(s); //한 루프당 제거된 0 개수
            loop ++;
            removed += zeros;
            
            int ones = s.length() - zeros; //변환 후 문자열 길이
            s = Integer.toString(ones, 2); //문자열 길이 2진수로 변환
        }
        
        return new int[] {loop, removed};
    }
}