import java.util.*;
class Solution {
    Queue<Node> queue = new LinkedList<>();
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0 ; i < n ; i++) {
            if (computers[i][i] == 1 && visited[i] == false) {
                queue.add(new Node(i));
                visited[i] = true;
                answer += 1;
            } 
            
            while(!queue.isEmpty()) {
                Node node = queue.poll();

                bfs(visited, node, computers, n);
            }
        }
        
        
        
        return answer;
    }
    
    public void bfs(boolean[] visited, Node node, int[][] computers, int n) {
        for (int j = 0 ; j < n ; j++) {
            if (computers[node.node][j]==1 && visited[j] == false) {
                queue.add(new Node(j));
                visited[j] = true;
            }
        }
        
    }
}

class Node {
    int node;
    
    public Node(int node) {
        this.node = node;
    }
}