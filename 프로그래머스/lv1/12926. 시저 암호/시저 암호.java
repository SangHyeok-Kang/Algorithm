class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isLowerCase(ch)){
                ch = (char)((ch-'a'+n)%26 + 'a');
                //System.out.print(ch);
            }
            else if(Character.isUpperCase(ch)){
                ch = (char)((ch-'A'+n)%26 + 'A');
                //System.out.print(ch);
            }
            answer += ch;
        }
        return answer;
    }
}