package week_5;
import java.util.*;

public class 프로그래머스_2_소수찾기_이상훈 {
    public boolean isPrime(int num){
        if(num==0 || num==1)
            return false;

        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0)
                return false;
        }
        return true;
    }

    public void dfs(char[] charArr, String numStr, boolean[] isUsed, Set<Integer> answerSet){

        int num = Integer.parseInt(numStr);
        if(isPrime(num))
            answerSet.add(num);

        for(int i=0; i<charArr.length; i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                dfs(charArr, numStr+charArr[i], isUsed, answerSet);
                isUsed[i] = false;
            }
        }
    }

    public int solution(String numbers) {
        char[] charArr = numbers.toCharArray();
        boolean[] isUsed = new boolean[numbers.length()];
        Set<Integer> answerSet = new HashSet<>();

        dfs(charArr, "0", isUsed, answerSet);
        return answerSet.size();
    }
}
