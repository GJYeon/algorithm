import java.util.*;
class Solution {
    int result = -1;
    Queue<Node> queue = new LinkedList<>();
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        queue.add(new Node(0, 0, 1));
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.m == m-1 && node.n == n-1){
                result = node.dist;
                break;
            }
            bfs(node, maps, visited, m, n);
        }
        answer = result;
        return answer;
    }
    
    public void bfs(Node node, int[][] maps, boolean[][] visited, int m, int n) {
        int a = node.m;
        int b = node.n;
        
        if (a-1 >= 0 && visited[b][a-1]==false && maps[b][a-1]==1) {
            visited[b][a-1]=true;
            queue.add(new Node(a-1, b, node.dist+1));
        }
        if (b-1 >= 0 && visited[b-1][a]==false && maps[b-1][a]==1) {
            visited[b-1][a]=true;
            queue.add(new Node(a, b-1, node.dist+1));
        }
        if (a+1 < m && visited[b][a+1]==false && maps[b][a+1]==1) {
            visited[b][a+1]=true;
            queue.add(new Node(a+1, b, node.dist+1));
        }
        if (b+1 < n && visited[b+1][a]==false && maps[b+1][a]==1) {
            visited[b+1][a]=true;
            queue.add(new Node(a, b+1, node.dist+1));
        }
    }
}

class Node {
    public int m;
    public int n;
    public int dist;
    
    Node(int m, int n, int dist) {
        this.m = m;
        this.n = n;
        this.dist = dist;
    }
}