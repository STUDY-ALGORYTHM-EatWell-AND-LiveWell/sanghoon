package week_1;

import java.util.Arrays;

public class 프로그래머스_2_배열자르기_이상훈 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4, 7, 14)));
    }

    public static int[] solution(int n, long left, long right) {
        int[] answers = new int[(int)(right-left+1)];

        for(long i=left; i<=right; i++){
            int row = (int)(i/n);
            int col = (int)(i%n);
            answers[(int)(i-left)] = Math.max(row, col)+1;
        }
        return answers;
    }
}
