import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        ArrayList<String> food_num = new ArrayList<>();
        ArrayList<String> food_num2 = new ArrayList<>();
        int indx = 0;
        for(int i = 1; i < food.length; i++){
            indx = food[i] / 2;
            if(indx != 0){
                for(int k = 0; k < indx; k++){
                    food_num.add(Integer.toString(i));
                }
            }
        }
        for(int i = 0; i<food_num.size(); i++){
            food_num2.add(food_num.get(food_num.size()-i-1));
        }
        String str = String.join("", food_num);
        String str2 = String.join("", food_num2);
        answer = str + "0" + str2;
        
        return answer;
    }
}