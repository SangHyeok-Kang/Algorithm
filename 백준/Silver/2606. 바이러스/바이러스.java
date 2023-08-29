import java.util.*;
import java.io.*;

/**
 *
 * @author host
 */
public class Main {
    static void bfs(int start, int[][] graph, boolean[] visited, int com_num) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        visited[start] = true;
        
        while(!q.isEmpty()){
            int nodeIndex = q.poll();
            
            for(int i = 1; i < com_num+1; i++){
                if(graph[nodeIndex][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                    count++;
                } 
            }
        }
        
        System.out.println(count);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int com_num = sc.nextInt(); // 컴퓨터 수
        int line = sc.nextInt(); //컴퓨터 쌍 수(간선 수)
        
        int[][] graph = new int[com_num + 1][com_num + 1];
        boolean[] visited = new boolean[com_num + 1];

        for (int i = 0; i < line; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            
         
            graph[num1][num2] = 1;
            graph[num2][num1] = 1;     
            
        }
        bfs(1, graph, visited, com_num);
    }
}
