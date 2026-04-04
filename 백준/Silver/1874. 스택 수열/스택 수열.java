import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     int num = Integer.parseInt(br.readLine());
     Stack<Integer> stack = new Stack<>();
     Queue<Character> queue = new LinkedList<>();
     int count = 1;
     boolean result = true;
     while(num > 0) {
         int s = Integer.parseInt(br.readLine());

         if (count < s) {
             while (count <= s) {
                 stack.push(count);
                 queue.add('+');
                 count++;
             }
             stack.pop();
             queue.add('-');
         } else if (count > s) {
             if (!stack.isEmpty()&&stack.peek()==s) {
                 stack.pop();
                 queue.add('-');
             } else {
                 result = false;
                 break;
             }
         } else {
             count++;
             queue.add('+');
             queue.add('-');
         }


         num--;
     }
        if (result) {
            while (!queue.isEmpty()) {
                bw.write(queue.poll() + "\n");
            }
        } else {
            bw.write("NO");
        }
        bw.flush();
        bw.close();
    }
}
