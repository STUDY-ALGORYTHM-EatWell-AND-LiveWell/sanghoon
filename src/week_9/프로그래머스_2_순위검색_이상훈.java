package week_9;
import java.util.*;

public class 프로그래머스_2_순위검색_이상훈 {
    class Solution {
        // 이진 탐색 : 주어진 점수 이상인 지원자의 수를 계산
        public int search(List<Integer> list, int num){
            int idx = 0;
            int jdx = list.size()-1;
            int firstIdx = list.size();
            while(idx<=jdx){
                int mid = (idx+jdx)/2;
                int midValue = list.get(mid);

                if (midValue >= num) {
                    firstIdx = Math.min(mid, firstIdx);
                    jdx = mid - 1;
                }
                else
                    idx = mid + 1;
            }
            return list.size()-firstIdx;
        }

        public int[] solution(String[] infos, String[] queries) {

            Map<String, List<Integer>> map = new HashMap<>();
            for(String info : infos){
                String[] parts = info.split(" ");
                String cond = parts[0] + parts[1] + parts[2] + parts[3];
                Integer score = Integer.valueOf(parts[4]);
                if(!map.containsKey(cond))
                    map.put(cond, new ArrayList<>());
                map.get(cond).add(score);
            }

            // 점수 리스트 정렬 -> 이진 탐색을 위한 사전 준비
            for(List<Integer> scoreList : map.values())
                Collections.sort(scoreList);

            // query를 기준으로 조건에 맞는 info 탐색
            int[] answer = new int[queries.length];
            for(int i=0; i<queries.length; i++){
                String query = queries[i];
                String[] parts = query.split(" ");
                int cnt = 0;

                for(Map.Entry<String, List<Integer>> entry : map.entrySet()){
                    String key = entry.getKey();
                    List<Integer> value = entry.getValue();
                    boolean flag = true;

                    // query의 조건 4개(언어, 직군, 경력, 소울푸드) 비교
                    for(int j=0; j<=3; j++){
                        String chunk = parts[j*2];
                        if(chunk.equals("-"))
                            continue;
                        if(!key.contains(chunk))
                            flag = false;
                    }

                    // 조건이 만족되면 이진 탐색으로 카운트 누적
                    if(flag)
                        cnt += search(value, Integer.valueOf(parts[7]));
                }
                answer[i] = cnt;
            }
            return answer;
        }
    }
}
