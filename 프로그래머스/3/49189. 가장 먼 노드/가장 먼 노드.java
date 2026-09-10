import java.util.*;
class Solution {
    Queue<Node> queue = new LinkedList<>();
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int p = 0;
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        for (int i = 0 ; i < edge.length ; i++) {
            if (edge[i][0] == 1) {
                queue.add(new Node(edge[i][1], 1));
                visited[edge[i][1]] = true;
            }
            if (edge[i][1] == 1) {
                queue.add(new Node(edge[i][0], 1));
                visited[edge[i][0]] = true;
            }
            
        }
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.dist > p) {
                p = node.dist;
                answer = 0;
            }
            if (p == node.dist) {
                answer += 1;
            }
            bfs(visited, edge, node);
            
        }
        
        
        return answer;
    }
    
    public void bfs(boolean[] visited, int[][] edge, Node node) {
        for (int i = 0 ; i < edge.length ; i++) {
            if (edge[i][0] == node.node && visited[edge[i][1]] == false) {
                queue.add(new Node(edge[i][1], node.dist + 1));
                visited[edge[i][1]] = true;
            }
            if (edge[i][1] == node.node && visited[edge[i][0]] == false) {
                queue.add(new Node(edge[i][0], node.dist + 1));
                visited[edge[i][0]] = true;
            }
        }
    }
}

class Node {
    int node;
    int dist;
    
    public Node(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}