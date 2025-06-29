package week_10;

public class 프로그래머스_1_문자열압축_이상훈 {
    class Solution {
        public int solution(String s) {

            int sLen = s.length();
            int answer = sLen;

            for(int i=1; i<=sLen/2; i++){
                String preStr = s.substring(0, i);
                int cnt = 1;
                int len = 0;
                for(int j=i; j<=sLen-i; j+=i){
                    String curStr = s.substring(j, j+i);
                    if(preStr.equals(curStr)){
                        cnt+=1;
                    }
                    else{
                        len += cnt==1 ? 0 : String.valueOf(cnt).length();
                        preStr = curStr;
                        len += preStr.length();
                        cnt = 1;
                    }
                }
                len += sLen%i;
                len += cnt==1 ? 0 : String.valueOf(cnt).length();
                len += preStr.length();
                answer = Math.min(answer, len);
            }

            return answer;
        }
    }
}
