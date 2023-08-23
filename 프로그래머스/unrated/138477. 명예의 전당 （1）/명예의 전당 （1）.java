import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> hall = new ArrayList<>();
        int min = 0;
        for(int i =0; i < score.length; i++){   
            if(hall.size() < k){
                hall.add(score[i]); 
                Collections.sort(hall);
                answer[i] = hall.get(0);
            }
            else if(hall.size() == k){
                min = hall.get(0);
                
                if(min < score[i]){
                    hall.remove(0);
                    hall.add(score[i]);
                    Collections.sort(hall);
                }
                answer[i] = hall.get(0);
            }
        }
        return answer;
    }
}