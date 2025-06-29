package week_11;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_19598_최소회의실개수_이상훈 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] meetings = new int[n][2];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, Comparator.comparingInt(m -> m[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(meetings[0][1]);

        for(int i=1; i<n; i++){
            int start = meetings[i][0];
            int end = meetings[i][1];

            if(!pq.isEmpty() && pq.peek() <= start){
                pq.poll();
            }

            pq.offer(end);
        }

        System.out.println(pq.size());


    }
}
