import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int back = 0;

        for (int i = 0 ; i<N ; i++) {
            String input = br.readLine();
            String[] arr = input.split(" ");

            if (arr.length > 1) {
                queue.add(Integer.parseInt(arr[1]));
                back = Integer.parseInt(arr[1]);
            } else {
                if (arr[0].equals("pop")) {
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(String.valueOf(queue.poll()) + "\n");
                    }
                } else if (arr[0].equals("size")) {
                    bw.write(String.valueOf(queue.size()) + "\n");
                } else if (arr[0].equals("empty")) {
                    if (queue.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                } else if (arr[0].equals("front")) {
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(String.valueOf(queue.peek())+ "\n");
                    }
                } else if (arr[0].equals("back")) {
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(String.valueOf(back)+ "\n");
                    }
                }
            }
        }
        bw.flush();
        bw.close();
    }
}