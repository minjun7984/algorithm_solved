import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        //음악 제목, 재생이 시작되고 끝난 시각, 악보를 제공함
        HashMap<String, String> map = new HashMap<>();
        String answer = "(None)";
        int max = Integer.MIN_VALUE;

        map.put("C#", "c"); map.put("D#", "d");
        map.put("F#", "f"); map.put("G#", "g"); map.put("A#", "a");

        for (int i = 0; i < musicinfos.length; i++) {
            String[] s = musicinfos[i].split(",");
            //0 => 시작 1 => 끝 2 => 악보..
            String[] startTime = s[0].split(":");
            String[] endTime = s[1].split(":");

            //총 재생시간 구하기
            int time = convertTime(startTime, endTime);

            //재생시간동안 총 악보를 구해보자...
            StringBuilder sb = new StringBuilder();
            String music = s[3]; //노래

            for (String key : map.keySet()) {
                m = m.replaceAll(key, map.get(key));
                music = music.replaceAll(key, map.get(key));
            }

            while (sb.length() < time) {
                sb.append(music);
            }

            String totalMusic = sb.toString();
            totalMusic = totalMusic.substring(0, time);

            if (totalMusic.contains(m)) {
                if (max < time) {
                    max = time;
                    answer = s[2];
                }
            }
        }
        return answer;
    }

    //시간 변환 함수
    public int convertTime(String[] startTime, String[] endTime) {
        int st = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
        int et = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);
        return et - st;
    }
}