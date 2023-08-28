/**
 * 문제번호 : 16173번 문제명 : 점프왕 쩰리(Small)
 */
import java.util.*;

public class Main {

    static String bfs(int size, int[][] map, boolean[][] visited) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0)); //시작점 넣기
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point temp = q.poll();
            //현재 x,y값 저장
            int cur_x = temp.x;
            int cur_y = temp.y;

            if (map[cur_x][cur_y] == -1) {
                return "HaruHaru";
            }
            for (int i = 0; i < size; i++) {
                int new_x;
                int new_y;
                if (i == 0) {
                    new_x = cur_x + map[cur_x][cur_y];
                    new_y = cur_y;
                } else {
                    new_x = cur_x;
                    new_y = cur_y + map[cur_x][cur_y];
                }

                if (new_x < 0 || new_x >= size || new_y < 0 || new_y >= size) continue;
                if (!visited[new_x][new_y]) {
                    q.add(new Point(new_x, new_y));
                    visited[new_x][new_y] = true;
                }
                
            }
        }
        return "Hing";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt(); //맵 크기 지정
        int[][] map = new int[size][size];
        boolean[][] visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = sc.nextInt(); //맵 값 넣기
            }
        }

        String result = bfs(size, map, visited);
        sc.close();

        System.out.println(result);
    }

    static class Point {

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
