class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int p_length = p.length();
        Long numP = Long.parseLong(p);
        for(int i = 0; i <= t.length()-p.length(); i++){
            String str = t.substring(i, i+p_length);
            Long numStr = Long.parseLong(str);
            if(numStr <= numP)
                answer++;
        }
        return answer;
    }
}