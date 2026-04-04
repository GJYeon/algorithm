import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < T ; i++) {
            String str = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            input = input.substring(1, input.length()-1);
            List<Integer> nums = new ArrayList<>();
            if(n>0) {
                String[] arr = input.split(",");
                for (int j = 0; j<n;j++){
                    nums.add(Integer.parseInt(arr[j]));
                }
            }


            boolean isErr = false;
            boolean isReverse = false;
            for (int k = 0; k<str.length();k++) {
                if (str.charAt(k) == 'R') {
                    isReverse = !isReverse;
                } else {
                    if (nums.isEmpty()) {
                        bw.write("error\n");
                        bw.flush();
                        isErr = true;
                        break;
                    } else {
                        if (!isReverse) {
                            nums.remove(0);
                        }else {
                            nums.remove(nums.size()-1);
                        }
                    }
                }
            }
            if (!isErr) {
                if (nums.size()>0) {
                    if (isReverse){
                        Collections.reverse(nums);
                    }
                    bw.write('[');
                    for(int q = 0 ; q < nums.size()-1 ; q++) {
                        bw.write(nums.get(q) + ",");
                    }
                    bw.write(String.valueOf(nums.get(nums.size()-1)));
                    bw.write("]\n");
                    bw.flush();
                } else {
                    bw.write("[]\n");
                    bw.flush();
                }


            }

        }

        bw.close();
    }
}
