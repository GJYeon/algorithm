import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N =  Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1 ; i <= N ; i++) {
            deque.add(i);
        }
        while(deque.size() != 1) {
            int f = deque.poll();
            if (deque.size()==1) {
                break;
            }
            int s = deque.poll();
            deque.add(s);
        }
        bw.write(String.valueOf(deque.poll()));
        bw.flush();
        bw.close();

    }
}
