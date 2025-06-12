package week_9;
import java.util.*;

public class 프로그래머스_3_징검다리건너기_이상훈 {

    class Solution {

        public int solution(int[] stones, int k) {

            int idx = 0;
            int jdx = 200000000;
            int answer = 0;
            while(idx<=jdx){
                int mid = (idx+jdx)/2;
                int maxCnt = 0;
                int cnt = 0;
                for(int i=0; i<stones.length; i++){
                    if(stones[i]-mid<0){
                        cnt +=1;
                        maxCnt = Math.max(maxCnt, cnt);
                    }
                    else {
                        cnt = 0;
                    }
                }

                if(maxCnt < k){
                    answer = Math.max(answer, mid);
                    idx = mid+1;
                }
                else if(maxCnt >= k){
                    jdx = mid-1;
                }
            }

            return answer;
        }
    }
}
