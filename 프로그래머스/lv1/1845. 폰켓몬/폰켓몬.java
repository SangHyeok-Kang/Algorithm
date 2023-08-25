import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int max_size = nums.length/2;
        HashSet<Integer> numSet = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++){
            numSet.add(nums[i]);
        }
             
        if(numSet.size() > max_size){
            answer = max_size;
        }else{
            answer = numSet.size();
        }
        
        return answer;
    }
}