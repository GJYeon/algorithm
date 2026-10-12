import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> genreCnt = new HashMap<>();
        Map<String, List<Integer[]>> detailMap = new HashMap<>();
        
        for (int i = 0 ; i < genres.length ; i++) {
            Integer[] detail = new Integer[2];
            detail[0] = i;
            detail[1] = plays[i];
            if (genreCnt.get(genres[i]) == null) {
                List<Integer[]> l = new ArrayList<>();
                l.add(detail);
                genreCnt.put(genres[i], plays[i]);
                detailMap.put(genres[i], l);
            } else {
                genreCnt.put(genres[i], genreCnt.get(genres[i]) + plays[i]);
                detailMap.get(genres[i]).add(detail);
            }
        }
        
        List<Map.Entry<String, Integer>> entryCnt = new ArrayList<>(genreCnt.entrySet());
        //List<Map.Entry<String, List<Integer[]>> entryDetail = new ArrayList<>(detailMap.entrySet());
        
        List<Integer> answerList = new ArrayList<>();
        
        entryCnt.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        for (Map.Entry<String, Integer> m : entryCnt) {
            String key = m.getKey();
            List<Integer[]> details = detailMap.get(key);
            if (details.size() == 1) {
                answerList.add(details.get(0)[0]);
            } else {
                details.sort((o1, o2) -> {
                    if (!o1[1].equals(o2[1])) {
                        return (o2[1].compareTo(o1[1]));
                    } else {
                        return (o1[0].compareTo(o2[0]));
                    }
                });
                answerList.add(details.get(0)[0]);
                answerList.add(details.get(1)[0]);
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0 ; i < answerList.size() ; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}