package week_9;
import java.util.*;

public class 프로그래머스_1_가장많이받은선물_이상훈 {
    class Solution {
        public int solution(String[] friends, String[] gifts) {
            Map<String, Map<String, Integer>> history = new HashMap<>();
            Map<String, Integer> score = new HashMap<>();

            // 초기화
            for(int i=0; i<friends.length; i++){
                history.put(friends[i], new HashMap<>());
            }

            // 선물 기록 분석
            for(String gift : gifts){
                String sender = gift.split(" ")[0];
                String receiver = gift.split(" ")[1];

                history.get(sender).put(receiver, history.get(sender).getOrDefault(receiver, 0)+1);
                score.put(sender, score.getOrDefault(sender, 0)+1);
                score.put(receiver, score.getOrDefault(receiver, 0)-1);
            }

            // 친구별로 다음달에 받는 선물 수 계산
            HashMap<String, Integer> cntMap = new HashMap<>();
            for(int i=0; i<friends.length; i++){
                for(int j=i+1; j<friends.length; j++){
                    String a = friends[i];
                    String b = friends[j];
                    int aToB = history.get(a).getOrDefault(b, 0);
                    int bToA = history.get(b).getOrDefault(a, 0);
                    if(aToB>bToA){
                        cntMap.put(a, cntMap.getOrDefault(a, 0)+1);
                    }
                    else if(aToB<bToA){
                        cntMap.put(b, cntMap.getOrDefault(b, 0)+1);
                    }
                    else{
                        int scoreA = score.getOrDefault(a, 0);
                        int scoreB = score.getOrDefault(b, 0);
                        if(scoreA>scoreB){
                            cntMap.put(a, cntMap.getOrDefault(a, 0)+1);
                        }
                        else if(scoreA<scoreB){
                            cntMap.put(b, cntMap.getOrDefault(b, 0)+1);
                        }
                    }
                }
            }

            // 가장 많은 선물을 받은 사람의 선물의 수 구하기
            int result = 0;
            for(int cnt : cntMap.values())
                result = Math.max(result, cnt);
            return result;
        }
    }
}
