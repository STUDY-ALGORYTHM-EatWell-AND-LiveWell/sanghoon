package week_2;

import java.util.Stack;

public class 프로그래머스_1_같은숫자는싫어_이상훈 {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for(int x: arr){
            if(stack.isEmpty() || stack.peek()!=x){
                stack.push(x);
            }
        }
        int size = stack.size();
        int[] answers = new int[size];
        int idx = size-1;
        while(!stack.isEmpty()){
            answers[idx--] = stack.pop();
        }

        return answers;
    }
}
