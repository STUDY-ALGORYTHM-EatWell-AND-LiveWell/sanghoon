package week_8;

import java.util.*;
import java.util.stream.Collectors;

public class 프로그래머스_2_수식최대화_이상훈 {
    class Solution {
        // 가능한 연산자 우선순위 조합 (총 3! = 6가지)
        public char[][] priorities = {{'+', '-', '*'}, {'+', '*', '-'}, {'-', '*', '+'},
                {'-', '+', '*'}, {'*', '+', '-'}, {'*', '-', '+'}};

        // 주어진 연산자를 기준으로 연산 수행
        public long cal(long first, long second, char op){
            long result = 0;
            switch(op) {
                case '+':
                    result = first+second;
                    break;
                case '-':
                    result = first-second;
                    break;
                case '*':
                    result = first*second;
                    break;
            }
            return result;
        }

        public long solution(String expression) {
            // 주어진 표현식을 숫자, 연산자 리스트로 추출
            String[] numArr = expression.split("[-+\\*]");
            List<Long> originalNumList = Arrays.stream(numArr).map(Long::parseLong)
                    .collect(Collectors.toList());

            List<Character> originalOpList = new ArrayList<>();
            for(int i=0; i<expression.length(); i++){
                char ch = expression.charAt(i);
                if(ch=='+' || ch=='-' || ch=='*')
                    originalOpList.add(ch);
            }

            // 모든 우선순위 조합에 대해 계산 시도
            long answer = 0;
            for(int i=0; i<priorities.length; i++){
                char[] priority = priorities[i];

                List<Long> numList = new ArrayList<>(originalNumList);
                List<Character> opList = new ArrayList<>(originalOpList);

                // 현재 우선순위에 따라 연산 수행
                for(int j=0; j<priority.length; j++){
                    for(int k=0; k<opList.size(); k++){
                        if(opList.get(k)==priority[j]){
                            long first = numList.get(k);
                            long second = numList.get(k+1);
                            numList.set(k, cal(first, second, priority[j]));
                            numList.remove(k+1);
                            opList.remove(k);
                            k--;
                        }
                    }
                }
                answer = Math.max(Math.abs(numList.get(0)), answer);
            }
            return answer;
        }
    }
}
