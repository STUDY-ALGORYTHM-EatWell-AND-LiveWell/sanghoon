package week_11;
import java.util.*;

public class 프로그래머스_2_양궁대회_이상훈 {

    class Solution {

        int maxScoreDiff = 0;
        int[] bestRyanArr = {-1};

        public void dfs(int remain, int idx, int[] ryan, int[] appeach){

            if(idx == 11){

                // 남은 화살은 0점
                if(remain>0)
                    ryan[10] += remain;

                int ryanScore = 0;
                int appeachScore = 0;

                for(int i=0; i<11; i++){
                    if(ryan[i]==0&&appeach[i]==0)
                        continue;
                    if(ryan[i]>appeach[i])
                        ryanScore += 10-i;
                    else
                        appeachScore += 10-i;
                }

                if(ryanScore > appeachScore){
                    int diff = ryanScore - appeachScore;
                    if (diff > maxScoreDiff) {
                        maxScoreDiff = diff;
                        bestRyanArr = ryan.clone();
                    }

                    else if(maxScoreDiff==diff){
                        for(int i=10; i>=0; i--){
                            if(ryan[i]>bestRyanArr[i]){
                                bestRyanArr = ryan.clone();
                                break;
                            }
                            else if(bestRyanArr[i] > ryan[i])
                                break;
                        }
                    }
                }

                if (remain > 0)
                    ryan[10] -= remain;
                return;
            }

            for(int i=0; i<=remain; i++){
                ryan[idx] = i;
                dfs(remain-i, idx+1, ryan, appeach);
                ryan[idx] = 0;
            }

        }

        public int[] solution(int n, int[] info) {

            dfs(n, 0, new int[11], info);
            return bestRyanArr;
        }
    }
}
