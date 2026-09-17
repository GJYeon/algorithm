import java.util.*;
class Solution {
    Queue<Node> queue = new LinkedList<>();
    public int solution(int[][] maps) {
        int answer = -1;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        queue.add(new Node(0,0, 1));
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == maps[0].length - 1 && node.y == maps.length - 1) {
                answer = node.dist;
                break;
            }
            
            bfs(node, visited, maps);
        }
        
        return answer;
    }
    
    public void bfs(Node node, boolean[][] visited, int[][] maps) {
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        for (int i = 0 ; i < 4 ; i++) {
            if (node.x + dx[i] >= 0 && node.x + dx[i] < maps[0].length && node.y + dy[i] >= 0 && node.y + dy[i] < maps.length) {
                if (visited[node.y + dy[i]][node.x + dx[i]] == false && maps[node.y + dy[i]][node.x + dx[i]] == 1) {
                    queue.add(new Node(node.x + dx[i], node.y + dy[i], node.dist + 1));
                    visited[node.y + dy[i]][node.x + dx[i]] = true;
                }
            }
        }
    }
    
}

class Node {
    int x;
    int y;
    int dist;
    
    public Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}