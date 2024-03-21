class Solution {
    boolean solution(String s) {
        /*
         * 방법 1,
         * 문자열을 모두 소문자로 변환 후, 하나씩 char형으로 변환하여 각각의 개수 구함
         * p와 y의 개수가 같으면 true 출력
         */
        boolean answer = true;
        int p_cnt = 0;
        int y_cnt = 0;
        
        s = s.toLowerCase();
        
        for(char c : s.toCharArray()){
            if(c == 'p') p_cnt++;
            if(c == 'y') y_cnt++;
        }
        if(p_cnt == y_cnt || p_cnt == 0 && y_cnt == 0) answer = true;
        else answer = false;
        
        return answer;
        
        /*
         * 방법 2,
         * 문자열을 모두 소문자로 변환 후, 
         * s의 길이와 p,y 각각을 공백으로 변환 후 길이를 빼서 길이를 구한다.
        
        s = s.toLowerCase();
        
        int ps = s.length() - s.replace("p", "").length();
        int ys = s.length() - s.replace("y", "").length();
        
        return ps == ys;
        */     
    }
}