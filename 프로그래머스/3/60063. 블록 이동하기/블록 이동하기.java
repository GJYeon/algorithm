import java.util.*;
class Solution {
    Queue<Node> queue = new LinkedList<>();
    public int solution(int[][] board) {
        int answer = 0;
        boolean[][] visitedC = new boolean[board.length - 1][board[0].length];
        boolean[][] visitedR = new boolean[board.length][board[0].length - 1];
        
        queue.add(new Node(0,0,0,1,0,true));
        visitedR[0][0] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x2 == board.length-1 && node.y2 == board[0].length-1) {
                answer = node.dist;
                break;
            }
            bfs(node, visitedC, visitedR, board);
        }
        
        
        return answer;
    }
    
    public void bfs (Node node, boolean[][] visitedC, boolean[][] visitedR, int[][] board) {
        if (node.isHorizon == true) { // 가로방향
            if (node.y2 + 1 < board[0].length && board[node.x2][node.y2 + 1] != 1 
                && visitedR[node.x1][node.y1 + 1] == false) {
                queue.add(new Node(node.x1, node.y1 + 1, node.x2, node.y2 + 1, node.dist + 1, true));
                visitedR[node.x1][node.y1 + 1] =true;
            }
            if (node.x1 + 1 < board.length && board[node.x1+1][node.y1] == 0 &&
               board[node.x2 + 1][node.y2] == 0 && visitedR[node.x1+1][node.y1] == false) {
                queue.add(new Node(node.x1+1, node.y1, node.x2+1, node.y2, node.dist+1, true));
                visitedR[node.x1+1][node.y1] = true;
            }
            if (node.y1 - 1 >= 0 && board[node.x1][node.y1-1]==0
               && visitedR[node.x1][node.y1 - 1] == false) {
                queue.add(new Node(node.x1, node.y1 - 1, node.x2, node.y2-1, node.dist+1, true));
                visitedR[node.x1][node.y1 - 1] = true;
            }
            if (node.x2 - 1 >= 0 && board[node.x1-1][node.y1] == 0 &&
               board[node.x2-1][node.y2] == 0 && visitedR[node.x1-1][node.y1] == false) {
                queue.add(new Node(node.x1-1, node.y1, node.x2-1,node.y2,node.dist+1, true));
                visitedR[node.x1-1][node.y1] = true;
            }
            if (node.x1 - 1 >= 0 && board[node.x1-1][node.y1] == 0 &&
               board[node.x2][node.y2-1] == 0 && board[node.x2-1][node.y2] == 0 &&
               visitedC[node.x1-1][node.y1] == false) {
                queue.add(new Node(node.x1-1, node.y1, node.x2, node.y2-1, node.dist+1, false));
                visitedC[node.x1-1][node.y1] = true;
            }
            if (node.x1 - 1 >= 0 && board[node.x1-1][node.y1+1] == 0 &&
               board[node.x1-1][node.y1] == 0 && visitedC[node.x1-1][node.y1+1] == false) {
                queue.add(new Node(node.x1-1, node.y1+1, node.x2, node.y2, node.dist+1, false));
                visitedC[node.x1-1][node.y1+1] = true;
            }
            if (node.x1 + 1 < board.length && board[node.x1+1][node.y1] == 0 &&
               board[node.x2+1][node.y2] == 0 && visitedC[node.x1][node.y1] == false) {
                queue.add(new Node(node.x1, node.y1, node.x1+1, node.y1, node.dist+1, false));
                visitedC[node.x1][node.y1] = true;
            }
            if (node.x2 + 1 < board.length && board[node.x2+1][node.y2] == 0 &&
               board[node.x1+1][node.y1] == 0 && visitedC[node.x2][node.y2] == false) {
                queue.add(new Node(node.x2, node.y2, node.x2+1, node.y2, node.dist+1, false));
                visitedC[node.x2][node.y2] = true;
            }
        } else { // 세로방향
            if (node.y1 + 1 < board[0].length && board[node.x1][node.y1+1] == 0 &&
               board[node.x2][node.y2+1] == 0 && visitedC[node.x1][node.y1+1] == false) {
                queue.add(new Node(node.x1, node.y1 + 1, node.x2, node.y2 + 1, node.dist+1, false));
                visitedC[node.x1][node.y1+1] = true;
            }
            if (node.x2 + 1 < board.length && board[node.x1+1][node.y1] == 0 &&
               board[node.x2+1][node.y2] == 0 && visitedC[node.x1+1][node.y1] == false) {
                queue.add(new Node(node.x1+1, node.y1, node.x2+1, node.y2, node.dist+1, false));
                visitedC[node.x1+1][node.y1] = true;
            }
            if (node.y1-1 >= 0 && board[node.x1][node.y1-1] == 0 &&
               board[node.x2][node.y2-1] == 0 && visitedC[node.x1][node.y1-1] == false) {
                queue.add(new Node(node.x1, node.y1 - 1, node.x2, node.y2 - 1, node.dist+1, false));
                visitedC[node.x1][node.y1-1] = true;
            }
            if (node.x1 - 1 >= 0 && board[node.x1-1][node.y1] == 0 &&
               board[node.x2-1][node.y2] == 0 && visitedC[node.x1-1][node.y1] == false) {
                queue.add(new Node(node.x1-1, node.y1, node.x2-1, node.y1, node.dist+1, false));
                visitedC[node.x1-1][node.y1] = true;
            }
            if (node.y1 + 1 < board[0].length && board[node.x1][node.y1+1] == 0 &&
               board[node.x2][node.y2+1] == 0 && visitedR[node.x1][node.y1] == false) {
                queue.add(new Node(node.x1, node.y1, node.x1, node.y1+1, node.dist+1, true));
                visitedR[node.x1][node.y1] = true;
            }
            if (node.y1 + 1 < board[0].length && board[node.x2][node.y2+1] == 0 && 
               board[node.x1][node.y1+1] == 0 && visitedR[node.x2][node.y1] == false) {
                queue.add(new Node(node.x2, node.y2, node.x2, node.y2+1, node.dist+1, true));
                visitedR[node.x2][node.y1] = true;
            }
            if (node.y1 - 1 >= 0 && board[node.x1][node.y1 - 1] == 0 &&
               board[node.x2][node.y2 - 1] == 0 && visitedR[node.x1][node.y1-1] == false) {
                queue.add(new Node(node.x1, node.y1-1, node.x1, node.y1, node.dist+1, true));
                visitedR[node.x1][node.y1-1] = true;
            }
            if (node.y1 - 1 >= 0 && board[node.x2][node.y2 - 1] == 0 &&
               board[node.x1][node.y1 - 1] == 0 && visitedR[node.x2][node.y2-1]==false) {
                queue.add(new Node(node.x2, node.y2-1, node.x2, node.y2, node.dist+1, true));
                visitedR[node.x2][node.y2-1]=true;
            }
        }
    }
}

class Node {
    int x1;
    int y1;
    int x2;
    int y2;
    int dist;
    boolean isHorizon;
    
    public Node(int x1, int y1, int x2, int y2, int dist, boolean isHorizon) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.dist = dist;
        this.isHorizon = isHorizon;
    }
}