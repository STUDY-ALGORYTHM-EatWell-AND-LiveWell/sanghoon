package week_2;
import java.util.*;

public class 프로그래머스_2_프로세스_이상훈 {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<priorities.length; i++){
            queue.offer(new int[]{i, priorities[i]});
            pq.offer(priorities[i]);
        }

        int order = 1;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentIdx = current[0];
            int currentValue = current[1];

            if(currentValue<pq.peek()){
                queue.offer(current);
            }
            else{
                if(currentIdx==location){
                    return order;
                }
                pq.poll();
                order++;
            }
        }
        return -1;
    }
}
