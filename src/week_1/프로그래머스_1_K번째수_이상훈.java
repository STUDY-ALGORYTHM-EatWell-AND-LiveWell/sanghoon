package week_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 프로그래머스_1_K번째수_이상훈 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution(array, commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answers = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int[] command = commands[i];
            int s = command[0];
            int e = command[1];
            int k = command[2];
            List<Integer> list = new ArrayList<>();
            for(int j=s-1; j<=e-1; j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            answers[i] = list.get(k-1);
        }
        return answers;
    }
}
