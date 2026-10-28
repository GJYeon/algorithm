import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int idx = 0;
        int time = 540;
        int tmpm = m;
        
        Arrays.sort(timetable);
        Integer[] minutetable = new Integer[timetable.length];
        
        for (int i = 0 ; i < timetable.length ; i++) {
            String[] list = timetable[i].split(":");
            Integer hour = Integer.parseInt(list[0]);
            Integer minute = Integer.parseInt(list[1]);
            minutetable[i] = hour * 60 + minute;
        }
        
        int cnt = n;
        
        for (int i = 0 ; i < n - 1; i++) {
            while (idx < timetable.length && time >= minutetable[idx] && tmpm > 0) {
                tmpm -= 1;
                idx++;
            }
            
            time += t;
            tmpm = m;
            cnt -= 1;
        }
        
        if (cnt==1) {
            while (idx < timetable.length && time >= minutetable[idx] && tmpm > 0) {
                tmpm -= 1;
                idx++;
            }
            if (tmpm == 0) {
                idx -= 1;
                time = minutetable[idx] - 1;
                int hour = time / 60;
                int minute = time % 60;
                String strH = hour < 10 ? "0" + hour : "" + hour;
                String strM = minute < 10 ? "0" + minute : "" + minute;
                return strH + ":" + strM;
            } else {
                int hour = time / 60;
                int minute = time % 60;
                String strH = hour < 10 ? "0" + hour : "" + hour;
                String strM = minute < 10 ? "0" + minute : "" + minute;
                return strH + ":" + strM;
            }
        }
        
        return answer;
    }
}