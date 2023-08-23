import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int min = 0;
        int mul = 0;
        Integer[] B2 = new Integer[B.length];
        
        Arrays.sort(A);
        
        for(int i = 0; i < B.length; i++){
            B2[i] = B[i];
        }
        
        Arrays.sort(B2, Collections.reverseOrder());
        
        for(int i = 0; i < A.length; i++){
            mul = A[i] * B2[i];
            answer += mul;
        }
        return answer;
    }
}