import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        // ✅ DFS 탐색을 통해 합이 target이 되는 경우의 수를 구한다.
        // 초기 호출: 인덱스 0부터 시작하며, 현재 합(cur)은 0으로 설정
        return dfs(numbers, 0, target, 0);
    }
    
    // 깊이 우선 탐색(DFS) 메서드
    // numbers: 주어진 숫자 배열
    // index: 현재 탐색 중인 배열의 인덱스
    // target: 목표로 하는 합
    // cur: 현재까지 계산된 합
    int dfs(int[] numbers, int index, int target, int cur) {
        // 모든 숫자를 다 사용한 경우 (탐색이 끝난 경우)
        if (index == numbers.length) {
            // 현재 합(cur)이 목표 값(target)과 같다면 경우의 수 1을 반환
            return (cur == target) ? 1 : 0;
        }
        
        int sum = 0;
        // 현재 인덱스의 숫자를 더하는 경우
        sum += dfs(numbers, index + 1, target, cur + numbers[index]);
        // 현재 인덱스의 숫자를 빼는 경우
        sum += dfs(numbers, index + 1, target, cur - numbers[index]);
        
        // 두 경우의 수를 합산하여 반환
        return sum;
    }
}
