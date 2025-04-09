package week_1;

import java.util.Arrays;

public class 프로그래머스_3_추석트래픽_이상훈 {
    public static void main(String[] args) {
        String[] lines =
                {
                        "2016-09-15 01:00:04.002 2.0s",
                        "2016-09-15 01:00:07.000 2s"
                };
        System.out.println(Arrays.toString(new int[]{(solution(lines))}));
    }

    // 초 단위로 변환
    public static int transToSeconds(String str){
        int seconds = 0;
        String[] strArr = str.split(":");
        seconds += Integer.valueOf(strArr[0])*60*60;
        seconds += Integer.valueOf(strArr[1])*60;
        seconds += Integer.valueOf(strArr[2]);
        return seconds;
    }

    public static int solution(String[] lines) {
        int[][] lineArr = new int[lines.length][2];
        for(int i=0; i<lines.length; i++){
            String line = lines[i];
            String s = line.substring(11, 23);
            String[] tArr = line.substring(24, line.length()-1).split("\\.");

            // 응답 완료 시각을 ms로 변환
            int endedTime = transToSeconds(s.split("\\.")[0])*1000;
            endedTime += Integer.valueOf(s.split("\\.")[1])*1;

            // 응답 요청 시각을 ms로 변환
            int startedTime = endedTime - Integer.valueOf(tArr[0])*1000 +1;
            if(tArr.length==2)
                startedTime -= Integer.valueOf(tArr[1]);

            lineArr[i][0] = startedTime;
            lineArr[i][1] = endedTime;
        }

        int answer = 0;
        for(int i=0; i<lines.length; i++){
            int cnt = 1;
            for(int j=i+1; j<lines.length; j++){
                if(lineArr[i][1]+999>=lineArr[j][0]){
                    cnt++;
                }
            }
            answer = Math.max(cnt, answer);
        }
        return answer;
    }
}
