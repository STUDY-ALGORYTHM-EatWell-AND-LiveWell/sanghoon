package week_8;
import java.util.*;

public class 프로그래머스_1_신고결과받기_이상훈 {

    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {

            // id에 대한 인덱스 저장
            Map<String, Integer> idxMap = new HashMap<>();
            for(int i=0; i<id_list.length; i++){
                idxMap.put(id_list[i], i);
            }

            // 유저별 신고한 사람들 저장
            Map<String, Set<String>> map = new HashMap<>();
            for(int i=0; i<id_list.length; i++){
                map.put(id_list[i], new HashSet<>());
            }
            for(int i=0; i<report.length; i++){
                String[] tem = report[i].split(" ");
                map.get(tem[1]).add(tem[0]);
            }

            // 메일 받는 횟수 계산
            int[] answers = new int[id_list.length];
            for(int i=0; i<id_list.length; i++){
                String reported = id_list[i];
                Set<String> reporterSet = map.get(reported);
                if(reporterSet.size()>=k){
                    for(String reporter : reporterSet){
                        answers[idxMap.get(reporter)]+=1;
                    }
                }
            }
            return answers;
        }
    }
}
