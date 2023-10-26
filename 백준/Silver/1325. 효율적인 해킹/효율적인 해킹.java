import java.util.*;
import java.io.*;

/**
 * 문제번호 : 1325번 
 * 문제명 : 효율적인 해킹
 */
public class Main {
    static int N,M;
    static ArrayList <Integer>[] graph;
    static boolean[] visited;
    static int max;
    static int[] cntArr;
    
    static void bfs(int start){
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        visited[start] = true;
        
        while(!q.isEmpty()){
            int nodeIndex = q.poll();
            
            for(int i : graph[nodeIndex]){
                if(!visited[i]){
                    cntArr[i]++;
                    visited[i] = true;
                    q.add(i);                 
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
        M = Integer.parseInt(st.nextToken()); // 줄 개수

        graph  = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++) graph[i] = new ArrayList <Integer>();
        
        
        cntArr = new int[N+1];
        
        for(int i = 0 ;  i < M; i++){
            st = new StringTokenizer(bf.readLine());
            
            int num1 = Integer.parseInt(st.nextToken()); 
            int num2 = Integer.parseInt(st.nextToken()); 
            
            graph[num1].add(num2);
        }
        
        for(int i = 1; i < N+1; i++){
            visited = new boolean[N+1];
            bfs(i);
        }
        
        max = 0;
        for(int i = 1; i <= N; i++){
            max = Math.max(max, cntArr[i]);
        }
        
        
        for (int i=1; i<N+1; i++) 
            if (max == cntArr[i]) 
                System.out.print(i+" ");
    } 
}