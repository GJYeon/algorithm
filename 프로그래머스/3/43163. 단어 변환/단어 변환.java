import java.util.*;
class Solution {
    Queue<Node> queue = new LinkedList<>();
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        
        for (int i = 0 ; i < words.length ; i++) {
            int cnt = 0;
            if (visited[i] == true) {
                continue;
            }
            for (int j = 0 ; j < begin.length() ; j++) {
                if (begin.charAt(j) != words[i].charAt(j)) {
                    cnt += 1;
                }
            }
            if (cnt == 1) {
                queue.add(new Node(i, 1));
                visited[i] = true;
            }
        }
        
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (words[node.node].equals(target)) {
                answer = node.dist;
                break;
            }
            bfs(node, visited, words);
        }
        
        return answer;
    }
    
    public void bfs(Node node, boolean[] visited, String[] words) {
        String begin = words[node.node];
        for (int i = 0 ; i < words.length ; i++) {
            int cnt = 0;
            if (visited[i] == true) {
                continue;
            }
            for (int j = 0 ; j < begin.length() ; j++) {
                if (begin.charAt(j) != words[i].charAt(j)) {
                    cnt += 1;
                }
            }
            if (cnt == 1) {
                queue.add(new Node(i, node.dist + 1));
                visited[i] = true;
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