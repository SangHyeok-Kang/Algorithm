import java.util.*;

/**
 *
 * @author host
 */
public class Main {
    static void bfs(int a, int k, boolean[] visited) {
        Queue<Temp> q = new LinkedList<>();
        q.add(new Temp(a, 0));
        
        while(!q.isEmpty()){
            Temp temp = q.poll();
            
            int cur_a = temp.x;
            int count = temp.count;
                
            if(cur_a == k){
                System.out.println(count);
                break;
            }
            
            if((cur_a*2) <= k){
                visited[cur_a*2] = true;
                q.add(new Temp(cur_a*2, count+1));
            }
            
            if(!visited[cur_a+1]){
                q.add(new Temp(cur_a+1, count+1));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int k = sc.nextInt();
        
        boolean[] visited = new boolean[k+1];
        
        bfs(a, k, visited);
    }

    static class Temp {
        int x;
        int count;

        Temp(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }
}