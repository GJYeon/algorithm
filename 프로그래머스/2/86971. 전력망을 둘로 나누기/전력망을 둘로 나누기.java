import java.util.*;
class Solution {
    Queue<Node> queue = new LinkedList<>();
    public int solution(int n, int[][] wires) {
        int answer = n;
        for (int i = 0 ; i < wires.length ; i++) {
            boolean[] visited = new boolean[n+1];
            if (i == 0) {
                int n1 = wires[1][0];
                int n2 = wires[1][1];
                queue.add(new Node(n1));
                queue.add(new Node(n2));
                visited[n1] = true;
                visited[n2] = true;
            } else {
                int n1 = wires[0][0];
                int n2 = wires[0][1];
                queue.add(new Node(n1));
                queue.add(new Node(n2));
                visited[n1] = true;
                visited[n2] = true;
            }
            
            
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                bfs(node, visited, wires, i);
            }
            int cnt = 0;
            for (int j = 1 ; j < n+1 ; j++) {
                if (visited[j] == true) {
                    cnt += 1;
                }
            }
            int cnt2 = n - cnt;
            int result = cnt > cnt2 ? cnt - cnt2 : cnt2 - cnt;
            answer = answer > result ? result : answer;
        }
        return answer;
    }
    
    public void bfs(Node node, boolean[] visited, int[][] wires, int x) {
        for (int i = 0 ; i < wires.length ; i++) {
            if (i == x) {
                continue;
            } else {
                if (node.node == wires[i][0] && visited[wires[i][1]] == false) {
                    queue.add(new Node(wires[i][1]));
                    visited[wires[i][1]] = true;
                } else if (node.node == wires[i][1] && visited[wires[i][0]] == false) {
                    queue.add(new Node(wires[i][0]));
                    visited[wires[i][0]] = true;
                }
            }
        }
    }
}

class Node {
    int node;
    
    public Node (int node) {
        this.node = node;
    }
}