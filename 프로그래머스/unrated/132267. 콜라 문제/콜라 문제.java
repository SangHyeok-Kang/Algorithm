import java.util.*;

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int poss_exchange = 0;
        int ret_bott = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while(n >= a){           
            ret_bott = (n/a)*b;
            result.add(ret_bott);
            n = (n/a)*b + (n%a);
        }
        for(int i =0; i< result.size(); i++){
            answer += result.get(i);
        }
        
        return answer;
    }
}