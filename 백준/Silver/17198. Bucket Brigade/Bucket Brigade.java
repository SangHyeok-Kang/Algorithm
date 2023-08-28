
import java.util.*;
import java.io.*;

/**
 * 문제 번호 : 17198 문제 명 : Bucket Brigade
 */
public class Main {

    static void bfs(int barn_x, int barn_y, char[][] map, boolean[][] visited) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(barn_x, barn_y, 0));

        while (!q.isEmpty()) {
            Point temp = q.poll();

            int cur_x = temp.x;
            int cur_y = temp.y;
            int cur_len = temp.len;

            if (map[cur_x][cur_y] == 'L') {
                System.out.println(cur_len - 1);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int new_x = cur_x + dx[i];
                int new_y = cur_y + dy[i];

                if (new_x < 0 || new_x >= 10 || new_y < 0 || new_y >= 10) {
                    continue;
                }
                if (map[new_x][new_y] == 'R') {
                    continue;
                }

                if (!visited[new_x][new_y]) {
                    visited[new_x][new_y] = true;
                    q.add(new Point(new_x, new_y, cur_len+1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[10][10];
        boolean[][] visited = new boolean[10][10];

        int barn_x = 0, barn_y = 0;

        for (int i = 0; i < 10; i++) {
            String str = br.readLine();
            for (int j = 0; j < 10; j++) {
                map[i][j] = str.charAt(j);
                if (str.charAt(j) == 'B') { //불난곳을 기록 해둠 
                    barn_x = i;
                    barn_y = j;
                }
            }
        }
        
        bfs(barn_x, barn_y, map, visited);
    }

    static class Point {

        int x;
        int y;
        int len;

        Point(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
}
