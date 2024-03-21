class Solution {
    private static final int[] dx = {0, -1, 1, 0};
    private static final int[] dy = {-1, 0, 0, 1};
    
    //2자리 건너편에 사람이 있는지 확인
    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude){
        for(int d = 0; d < 4; d++){
            if(d == exclude) continue;
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            if(room[ny][nx] == 'P') return true;
        }
        return false;
    }
    
    private boolean isDistanced(char[][] room, int x, int y){
        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            switch (room[ny][nx]){
                case 'P' : return false; //근처에 사람이 있을 경우 거리두기 실패
                case 'O' : 
                    if(isNextToVolunteer(room, nx, ny, 3-d)) return false;
                    break;
            }
        }
        return true;
    }
    
    //사람이 있는 좌석 확인 후 좌표값 전달
    private boolean isDistanced(char[][] room){
        for(int y = 0; y < room.length; y++){
            for(int x = 0; x < room[y].length; x++){
                if(room[y][x] != 'P') continue;
                if(!isDistanced(room, x, y)) return false;
            }
        }
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i = 0; i < answer.length; i++){
            String[] place = places[i]; //각 대기실 넣어줄 배열 선언
            char[][] room = new char[place.length][]; //거리두기 결과 저장할 배열 선언
            
            for(int j = 0;  j < room.length; j++){
                room[j] = place[j].toCharArray();    
            }
            
            if(isDistanced(room)){
                answer[i] = 1;  
            } else {
                answer[i] = 0;
            }
        }      
        return answer;
    }
}