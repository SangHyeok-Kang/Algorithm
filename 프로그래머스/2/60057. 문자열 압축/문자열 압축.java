import java.util.*;

class Solution {
    //source를 length만큼씩 잘라 tokens 리스트에 추가
    private List<String> split(String source, int length){
        List<String> tokens = new ArrayList<>();
        //문자열 자를 때, 1부터 s의 길이만큼 진행
        for(int start = 0; start < source.length(); start+=length){
            //end인덱스가 문자열 범위 밖이라면 문자열 끝을 end인덱스로 설정.
            int end = start + length;
            if(end > source.length()) 
                end = source.length();
            
            //start부터 end까지 잘라 token 리스트에 추가
            tokens.add(source.substring(start, end));
        }
        
        return tokens;
    }
    
    private int compress(String source, int length){
        //압축한 문자열 길이 반환
        StringBuilder sb = new StringBuilder();
        
        String last = ""; //직전에 등장한 문자열 담는 변수
        int count = 0; //동일한 문자열 개수 count
        
        for(String token : split(source, length)){
            if(token.equals(last)){
                count++;
            }else{
                if(count > 1) sb.append(count);
                sb.append(last);
                last = token;
                count = 1;
            }
        }
        if(count > 1) sb.append(count);
        sb.append(last);
        
        return sb.length();
    }
    
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        
        for(int i = 1; i <= s.length(); i++){
            //문자열 압축 후, 가장 짧은 길이 선택
            int compressed = compress(s, i);
            if(compressed < min){
                min = compressed;
            }
        }
            
        int answer = min;
        return answer;
    }
}