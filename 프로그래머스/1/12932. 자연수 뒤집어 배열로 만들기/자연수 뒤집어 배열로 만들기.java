class Solution {
    /*
        1. long타입 n을 String타입으로 형변환
        2. reverse문법 사용하여 문자열 뒤집기
        3. 한글자씩 자른 후 배열에 삽입
        4. char타입을 int타입으로 형변환 후 return
    */
    public int[] solution(long n) {
        String str = Long.toString(n); //long to string
        String reversed = new StringBuilder(str).reverse().toString(); // reverse 문법 외우기
        char[] arr = reversed.toCharArray(); // String to char[];
        
        
        int[] answer = new int[arr.length];
        for(int i = 0; i < answer.length; i++){
            answer[i] = arr[i] - '0';
        }
        return answer;
    }
}