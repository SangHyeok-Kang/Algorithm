import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        String[] strArr = s.split(" ");
        for(int i = 0; i < strArr.length; i++){
            String str = strArr[i];
            
            if(str.length() == 0){
                sb.append(" ");
                continue;
            }
            sb.append(str.substring(0,1).toUpperCase());
            sb.append(str.substring(1, str.length()));
            sb.append(" ");
        }
        if(!" ".equals(s.substring(s.length()-1, s.length()))){
            sb.deleteCharAt(sb.lastIndexOf(" "));
        }
        answer = sb.toString();  
            
        //마지막에 공백이 더해져서 그 공백을 제외한 answer값 반환
        return answer;
    }
}