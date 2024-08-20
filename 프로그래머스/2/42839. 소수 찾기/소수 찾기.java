import java.util.*;

class Solution {
    // 후보 숫자를 저장할 Set. Set은 중복을 허용하지 않으므로 중복된 숫자 조합이 자동으로 제거.
    Set<Integer> candidates = new HashSet<>();
    
    public int solution(String numbers) {
        // 재귀를 이용하여 숫자 조합 생성
        permutation(numbers, 0, new boolean[numbers.length()], 0);

        int answer = 0;
        // 생성된 후보 숫자들 중 소수의 개수를 셈
        for (int num : candidates) {
            if (isPrime(num)) answer++;
        }
        return answer;
    }
    
    // 숫자 조합을 생성하는 재귀 함수
    // numbers: 입력으로 주어진 숫자 문자열
    // current: 현재까지 조합된 숫자 값
    // visited: 각 자리 숫자의 사용 여부를 표시하는 배열
    // digit: 현재까지 몇 자리의 숫자를 조합했는지를 나타내는 변수
    void permutation(String numbers, int current, boolean[] visited, int digit) {
        // 현재 조합한 자릿수가 숫자 문자열의 길이와 같다면 종료 (더 이상 조합할 수 없음)
        if (digit == numbers.length()) return;
        
        // 숫자 문자열의 각 자리수에 대해 반복
        for (int i = 0; i < numbers.length(); i++) {
            // 이미 사용한 자리수라면 건너뜀
            if (visited[i]) continue;
            
            // 새로운 숫자 조합을 만듦
            // (현재 조합된 숫자 + 새로 추가된 숫자) * 해당 자리의 자릿수만큼 10의 거듭제곱을 곱함
            int newValue = current + (int) ((numbers.charAt(i) - '0') * Math.pow(10, digit));
            // 새로 만든 숫자 조합을 후보 숫자 Set에 추가
            candidates.add(newValue);
            
            // 현재 자리를 사용했다고 표시
            visited[i] = true;
            // 재귀 호출로 다음 자리수 조합을 시도
            permutation(numbers, newValue, visited, digit + 1);
            // 백트래킹을 위해 현재 자리를 다시 미사용으로 표시
            visited[i] = false;
        }
    }
    
    // 소수 판별 함수
    // n: 소수인지 확인할 숫자
    boolean isPrime(int n) {
        // 2보다 작은 수는 소수가 아님
        if (n < 2) return false;
        
        // 2부터 n의 제곱근까지 나누어 떨어지는지 확인
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;  // 나누어 떨어지면 소수가 아님
        }
        return true;  // 위 조건을 모두 통과하면 소수임
    }
}
