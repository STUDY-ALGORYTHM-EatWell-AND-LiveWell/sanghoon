package week_11;
import java.util.*;

public class 프로그래머스_1_이모티콘할인행사_이상훈 {
    class Solution {

        List<List<Integer>> permList = new ArrayList<>();

        void calPermutation(int idx, int len, List<Integer> list){
            int[] arr = {10, 20, 30, 40};

            if(idx==len){
                permList.add(new ArrayList<>(list));
                return;
            }

            for(int i=0; i<4; i++){
                list.add(arr[i]);
                calPermutation(idx+1, len, list);
                list.remove(list.size() - 1);
            }

        }

        class Result implements Comparable<Result>{
            int totalCnt;
            int totalPrice;

            public Result(int totalCnt, int totalPrice){
                this.totalCnt = totalCnt;
                this.totalPrice = totalPrice;
            }

            @Override
            public int compareTo(Result r){
                if(this.totalCnt==r.totalCnt)
                    return r.totalPrice-this.totalPrice;
                else
                    return r.totalCnt - this.totalCnt;
            }
        }

        public int[] solution(int[][] users, int[] emoticons) {
            // 가능한 순열 구하기
            calPermutation(0, emoticons.length, new ArrayList<>());

            PriorityQueue<Result> pq = new PriorityQueue<>();
            for(List<Integer> perm : permList){
                int totalPrice = 0;
                int totalCnt = 0;
                for(int[] user : users){
                    int ratio = user[0];
                    int temPrice = user[1];
                    int curPrice = 0;

                    for(int i=0; i<perm.size(); i++){
                        if(ratio<=perm.get(i)){
                            curPrice += emoticons[i]*(100-perm.get(i))/100;
                        }
                    }

                    if(curPrice>=temPrice)
                        totalCnt +=1;
                    else
                        totalPrice += curPrice;
                }
                pq.offer(new Result(totalCnt, totalPrice));
            }

            int[] answers = new int[2];
            Result r = pq.poll();
            answers[0] = r.totalCnt;
            answers[1] = r.totalPrice;
            return answers;
        }
    }
}
