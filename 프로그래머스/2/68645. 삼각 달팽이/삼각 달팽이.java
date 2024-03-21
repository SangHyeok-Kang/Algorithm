class Solution {
    private static final int[] dx = {0, 1, -1}; //변하지 않는 값이기 때문에 final로 선언
    private static final int[] dy = {1, 0, -1};
    
    public int[] solution(int n) {
        int[][] triangle = new int [n][n];
        int x = 0, y = 0; //x,y 좌표 선언
        int num = 1; //넣을 정수 선언
        int d = 0; //방향 조절을 위한 변수 선언
        
        while(true){
            triangle[y][x] = num++;
            //바뀌는 좌표 선언
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            //범위를 벗어났거나 더 이상 값을 넣을 수 없을 때, 방향 변경
            if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0){
                //방향 변경
                d = (d + 1) % 3;
                
                nx = x + dx[d];
                ny = y + dy[d];
                
                //방향 변경 후에도 범위를 벗어 났을 시, 더 이상 넣을 공간 없음
                if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) break;
            }
            x = nx;
            y = ny;
            
        }
        
        int[] answer = new int[num - 1];
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <=i; j++){
                answer[index++] = triangle[i][j];
            }
        }
        
        return answer;
    }
}