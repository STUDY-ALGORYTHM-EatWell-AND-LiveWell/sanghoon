package week_3;

import java.util.*;

public class 프로그래머스_2_의상_이상훈 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes){
            map.put(cloth[1], map.getOrDefault(cloth[1],0)+1);
        }

        int cnt = 1;
        for(int value : map.values()){
            cnt *= (value+1);
        }
        return cnt-1;
    }
}
