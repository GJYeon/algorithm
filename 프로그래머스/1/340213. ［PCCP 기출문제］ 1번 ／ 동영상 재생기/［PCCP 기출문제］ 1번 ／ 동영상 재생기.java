class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int startmin = Integer.parseInt(op_start.substring(0,2));
        int startsec = Integer.parseInt(op_start.substring(3,5));
        int endmin = Integer.parseInt(op_end.substring(0,2));
        int endsec = Integer.parseInt(op_end.substring(3,5));
        for (int i = 0 ; i<commands.length ; i++)
        {
            int min = Integer.parseInt(pos.substring(0,2));
            int sec = Integer.parseInt(pos.substring(3,5));

            if (startmin*100+startsec<=min*100+sec&& min*100+sec<=endmin*100+endsec) {
                pos = op_end;
            }
            if (commands[i].equals("prev")) {
                 min = Integer.parseInt(pos.substring(0,2));
                 sec = Integer.parseInt(pos.substring(3,5));
                if (sec-10 < 0) {
                    sec = sec - 10 + 60;
                    min -= 1;
                    if (min < 0){
                        sec = 0;
                        min = 0;
                    }
                } else {
                    sec = sec - 10;
                }
                String minTemp = String.format("%02d",min);
                String secTemp = String.format("%02d",sec);
                pos = minTemp + ":" + secTemp;
            } else if (commands[i].equals("next")) {
                min = Integer.parseInt(pos.substring(0,2));
                sec = Integer.parseInt(pos.substring(3,5));
                if (sec + 10 >= 60) {
                    sec = sec + 10 - 60;
                    min += 1;
                } else {
                    sec += 10;
                }
                String minTemp = String.format("%02d",min);
                String secTemp = String.format("%02d",sec);
                pos = minTemp + ":" + secTemp;
                int videomin = Integer.parseInt(video_len.substring(0,2));
                int videosec = Integer.parseInt(video_len.substring(3,5));
                if (min*100+sec>videomin*100+videosec) {
                    pos = video_len;
                }

            }
            min = Integer.parseInt(pos.substring(0,2));
            sec = Integer.parseInt(pos.substring(3,5));

            if (startmin*100+startsec<=min*100+sec&& min*100+sec<=endmin*100+endsec) {
                pos = op_end;
            }
        }
        answer = pos;
        return answer;
    }
}