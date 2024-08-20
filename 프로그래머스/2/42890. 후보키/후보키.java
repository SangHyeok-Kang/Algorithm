import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        // relation의 열(column) 개수를 가져옴
        int colSize = relation[0].length;

        // 후보키를 저장할 리스트 (각 후보키는 컬럼 인덱스들의 집합으로 표현)
        List<Set<Integer>> candidates = new ArrayList<>();

        // ✅ 1~n의 길이를 가진 컬럼 조합을 만듦
        for (int size = 1; size <= colSize; size++) {
            // 현재 길이(size)에 해당하는 모든 컬럼 조합 생성
            List<Set<Integer>> combinations = generateCombinations(colSize, size);
            for (Set<Integer> comb : combinations) {
                // ✅ 각 조합에 대해서 유일성 검사를 수행
                // ✅ 각 조합에 대해서 최소성 검사를 수행
                if (checkUnique(comb, relation) && checkMin(comb, candidates)) {
                    // 유일성과 최소성을 만족하는 조합은 후보키로 추가
                    candidates.add(comb);
                }
            }
        }
        // 최종적으로 발견된 후보키의 개수를 반환
        return candidates.size();
    }

    // 주어진 컬럼 조합이 relation에서 유일성을 가지는지 검사
    private boolean checkUnique(Set<Integer> cols, String[][] relation) {
        int rowSize = relation.length;
        // 각 행을 고유하게 식별할 수 있는 문자열을 저장할 Set
        Set<String> rowSet = new HashSet<>();
        for (String[] row : relation) {
            // 현재 조합의 컬럼을 사용하여 행의 값을 연결
            StringBuilder rowStr = new StringBuilder();
            for (int col : cols) {
                rowStr.append(row[col]);
            }
            // 해당 문자열이 이미 존재하면 유일성이 깨짐
            rowSet.add(rowStr.toString());
        }
        // 행 집합의 크기가 relation의 행 크기와 같다면 유일성을 만족
        if (rowSet.size() == rowSize) {
            return true;
        }
        return false;
    }

    // 주어진 조합이 최소성을 가지는지 검사
    private boolean checkMin(Set<Integer> cand, List<Set<Integer>> candKeys) {
        // 현재 조합이 기존의 후보키들에 포함되는지 검사
        for (Set<Integer> key : candKeys) {
            if (cand.containsAll(key)) {
                return false; // 포함된다면 최소성을 만족하지 않음
            }
        }
        return true; // 최소성을 만족함
    }

    // n개의 컬럼 중에서 r개를 뽑는 조합을 생성
    private List<Set<Integer>> generateCombinations(int n, int r) {
        List<Set<Integer>> combinations = new ArrayList<>();
        // 재귀를 통해 조합을 생성하는 헬퍼 함수 호출
        generateCombinationsHelper(new HashSet<>(), 0, n, r, combinations);
        return combinations;
    }

    // 조합을 재귀적으로 생성하는 함수
    private void generateCombinationsHelper(Set<Integer> current, int start, int n, int r, List<Set<Integer>> result) {
        // 현재 조합의 크기가 r이면 결과 리스트에 추가
        if (current.size() == r) {
            result.add(new HashSet<>(current));
            return;
        }

        // start부터 n까지의 인덱스에 대해 조합을 생성
        for (int i = start; i < n; i++) {
            current.add(i); // 현재 인덱스를 조합에 추가
            // 다음 인덱스로 재귀 호출
            generateCombinationsHelper(current, i + 1, n, r, result);
            // 백트래킹을 위해 현재 인덱스를 제거
            current.remove(i);
        }
    }
}
