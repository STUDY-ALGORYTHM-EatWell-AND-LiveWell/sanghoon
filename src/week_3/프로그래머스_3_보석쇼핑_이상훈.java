package week_3;

import java.util.*;

public class 프로그래머스_3_보석쇼핑_이상훈 {
    public int[] solution(String[] gems) {

        Set<String> set = new HashSet<>();
        for(int i=0; i<gems.length; i++){
            set.add(gems[i]);
        }
        int typeCnt = set.size();

        int minLen = Integer.MAX_VALUE;
        int[] answers = new int[2];
        Map<String, Integer> map = new HashMap<>();
        int j=0;
        for(int i=0; i<gems.length; i++){
            map.put(gems[i], map.getOrDefault(gems[i], 0)+1);

            while(map.size()==typeCnt){
                if(i-j+1<minLen){
                    minLen = Math.min(minLen, i-j+1);
                    answers[0]=j+1;
                    answers[1]=i+1;
                }
                String tem = gems[j++];
                map.put(tem, map.get(tem)-1);
                if(map.get(tem)==0)
                    map.remove(tem);
            }
        }

        return answers;
    }
}
