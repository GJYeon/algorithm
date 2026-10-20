import java.util.*;
class Solution {
    Queue<Node> queue = new LinkedList<>();
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        for (int i = 0 ; i < wires.length ; i++) {
            boolean[] visited = new boolean[n+1];
            if (i == 0) {
                queue.add(new Node(wires[1][0]));
                visited[wires[1][0]] = true;
                queue.add(new Node(wires[1][1]));
                visited[wires[1][1]] = true;
                while (!queue.isEmpty()) {
                    Node node = queue.poll();
                    bfs(node, wires, i,visited);
                }
            } else {
                queue.add(new Node(wires[0][0]));
                visited[wires[0][0]] = true;
                queue.add(new Node(wires[0][1]));
                visited[wires[0][1]] = true;
                
                while (!queue.isEmpty()) {
                    Node node = queue.poll();
                    bfs(node, wires, i,visited);
                }
            }
            int cnt = 0;
            for (int k = 1 ; k < visited.length ; k++) {
                if (visited[k] == true) {
                    cnt++;
                }
            }
            int d = cnt > n-cnt ? cnt * 2 - n : n - 2*cnt;
            answer = Math.min(answer, d);
        }
        
        
        
        
        return answer;
    }
    
    public void bfs(Node node, int[][] wires, int i, boolean[] visited) {
        for (int j = 0 ; j < wires.length ; j++) {
            if (i!=j) {
                if (node.node == wires[j][0] && visited[wires[j][1]] == false) {
                    queue.add(new Node(wires[j][1]));
                    visited[wires[j][1]] = true;
                } else if (node.node == wires[j][1] && visited[wires[j][0]]==false) {
                    queue.add(new Node(wires[j][0]));
                    visited[wires[j][0]] = true;
                }
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