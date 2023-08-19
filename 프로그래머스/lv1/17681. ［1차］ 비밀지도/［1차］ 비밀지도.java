class Solution {
    public String[] addZero(String bin, int n) {
        if(bin.length() != n) {
            String zero = "";
            for(int i=0; i<n-bin.length(); i++) {
                zero += "0";
            }
            bin = zero + bin;
        }

        return bin.split("");
    }
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String bin1;
        String bin2;
        String[] str_arr1;
        String[] str_arr2;
        String row ="";
        for(int i=0; i<n; i++) {
            row = "";
            bin1 = Integer.toBinaryString(arr1[i]);
            bin2 = Integer.toBinaryString(arr2[i]);
            
            str_arr1 = addZero(bin1, n);
            str_arr2 = addZero(bin2, n);
            
            for(int j=0; j<n; j++) {
                if("1".equals(str_arr1[j]) || "1".equals(str_arr2[j])) row += "#";
                else row += " ";
            }
            
            answer[i] = row;
        }
        
        return answer;
    }
}