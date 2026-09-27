import java.util.*;
class Solution {
    public int solution(int[][] jobss) {
        int answer = 0;
        
        
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1].compareTo(o2[1]);
            } else {
                if (o1[0] != o2[0]) {
                    return o1[0].compareTo(o2[0]);
                } else {
                    return o1[2].compareTo(o2[2]);
                }
            }
        });
        
        Integer[][] jobs = new Integer[jobss.length][3];
        for (int i = 0 ; i < jobss.length ;i++) {
            jobs[i][0] = jobss[i][0];
            jobs[i][1] = jobss[i][1];
            jobs[i][2] = i;
        }
        
        Arrays.sort(jobs, (o1, o2) -> (o1[0].compareTo(o2[0])));
        
        int idx = 0;
        int time = 0;
        int sum = 0;
        
        time = jobs[idx][0];
        pq.add(jobs[idx++]);
        while (idx < jobs.length && jobs[idx][0] == time) {
            pq.add(jobs[idx++]);
        }
                
        while (!pq.isEmpty()) {
            Integer[] temp1 = pq.poll();
            
            time += temp1[1];
            sum += time - temp1[0];
            
            if (idx == jobs.length) {
                continue;
            }
            
            while (jobs[idx][0] <= time) {
                pq.add(jobs[idx++]);
                if (idx == jobs.length) {
                    break;
                }
            }
            if (pq.isEmpty()) {
                
                time = jobs[idx][0];
                while (jobs[idx][0] <= time) {
                    pq.add(jobs[idx++]);
                    if (idx == jobs.length) {
                        break;
                    }
                }
            }
            
            
        }
        
        
 
        
        
        return sum / jobs.length;
    }
}