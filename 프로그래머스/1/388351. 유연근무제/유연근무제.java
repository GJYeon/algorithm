class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int min = 0, hour = 0;
        int[] failure = new int[schedules.length];
        for (int i = 0; i < schedules.length ; i++) {
            if ((schedules[i]+10)%100>=60) {
                    min = (schedules[i]+10)%100 - 60;
                    hour = schedules[i]/100 + 1;
                    schedules[i] = hour*100 + min;
                } else {
                schedules[i] += 10;
            }

            
            for(int j = 0 ; j < 7 ; j++){
                int day = (startday + j - 1) % 7;
                if (day == 5 || day == 6) continue;
                if (schedules[i]<timelogs[i][j]){
                    failure[i] = 1;
                    answer += 1;
                    break;
                }
                
                
            }
        }
        
        return schedules.length - answer;
    }
}