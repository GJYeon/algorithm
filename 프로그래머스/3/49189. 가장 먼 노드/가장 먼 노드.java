import java.util.*;
class Solution {
    Queue<Node> queue = new LinkedList<>();
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int max = 1;
        
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        queue.add(new Node(1, 1));
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (max == node.dist) {
                answer += 1;
            } else if (max < node.dist) {
                max = node.dist;
                answer = 1;
            }
            bfs(node, visited, edge);
        }
        
        return answer;
    }
    
    public void bfs(Node node, boolean[] visited, int[][] edge) {
        for (int i = 0 ; i < edge.length ; i++) {
            if (edge[i][0] == node.node && visited[edge[i][1]] == false) {
                visited[edge[i][1]] = true;
                queue.add(new Node(edge[i][1], node.dist + 1));
            } else if (edge[i][1] == node.node && visited[edge[i][0]] == false) {
                visited[edge[i][0]] = true;
                queue.add(new Node(edge[i][0], node.dist + 1));
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