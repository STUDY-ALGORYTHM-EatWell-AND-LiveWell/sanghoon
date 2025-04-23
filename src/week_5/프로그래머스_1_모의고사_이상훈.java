package week_5;
import java.util.*;

public class 프로그래머스_1_모의고사_이상훈 {

    public int[] solution(int[] answers) {
        int[] pick1 = {1, 2, 3, 4, 5};
        int[] pick2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pick3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] cnts = new int[3];
        for(int i=0; i<answers.length; i++){
            if(answers[i]==pick1[i%pick1.length])
                cnts[0] ++;
            if(answers[i]==pick2[i%pick2.length])
                cnts[1] ++;
            if(answers[i]==pick3[i%pick3.length])
                cnts[2] ++;
        }

        List<Integer> results = new LinkedList<>();
        int maxCnt = Math.max(cnts[0], Math.max(cnts[1], cnts[2]));

        for(int i=0; i<cnts.length; i++){
            if(maxCnt==cnts[i])
                results.add(i+1);
        }

        return results.stream().mapToInt(i->i).sorted().toArray();
    }
}
