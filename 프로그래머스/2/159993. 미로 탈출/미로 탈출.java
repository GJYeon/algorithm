import java.util.*;
class Solution {
    Queue<Node> queue = new LinkedList<>();
    Queue<Node> queue2 = new LinkedList<>();
    public int solution(String[] maps) {
        int answer = -1;
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        boolean[][] visited2 = new boolean[maps.length][maps[0].length()];
        for (int i = 0 ; i < maps.length ; i++) {
            for (int j = 0 ; j < maps[0].length() ; j++) {
                if (maps[i].charAt(j) == 'S') {
                    queue.add(new Node(j, i, 0));
                    visited[i][j] = true;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (maps[node.y].charAt(node.x) == 'L') {
                queue2.add(node);
                visited2[node.y][node.x] = true;
                break;
            }
            bfs(node, visited, maps);
        }
        
        while (!queue2.isEmpty()) {
            Node node = queue2.poll();
            if (maps[node.y].charAt(node.x)=='E') {
                answer = node.dist;
                break;
            }
            bfs2(node, visited2, maps);
        }
        return answer;
    }
    
    public void bfs(Node node, boolean[][] visited, String[] maps) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        for (int i = 0 ; i < 4 ; i++) {
            int x = node.x + dx[i];
            int y = node.y + dy[i];
            if (x >= 0 && x < maps[0].length() && y >= 0 && y < maps.length) {
                if (visited[y][x] == false && maps[y].charAt(x) != 'X') {
                    queue.add(new Node(x, y, node.dist + 1));
                    visited[y][x] = true;
                }
            }
        }
    }
    
    public void bfs2(Node node, boolean[][] visited, String[] maps) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        for (int i = 0 ; i < 4 ; i++) {
            int x = node.x + dx[i];
            int y = node.y + dy[i];
            if (x >= 0 && x < maps[0].length() && y >= 0 && y < maps.length) {
                if (visited[y][x] == false && maps[y].charAt(x) != 'X') {
                    queue2.add(new Node(x, y, node.dist + 1));
                    visited[y][x] = true;
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