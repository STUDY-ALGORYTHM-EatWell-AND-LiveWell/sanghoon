package week_8;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 백준_1197_최소스패닝트리_이상훈 {
    public static class Edge implements Comparable<Edge>{
        int s;
        int e;
        int v;

        public Edge(int s, int e, int v){
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            return this.v - o.v;
        }
    }

    public static int find(int x){
        if(arr[x]==x)
            return arr[x];
        else
            return arr[x] = find(arr[x]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a!=b)
            arr[b] = a;
    }

    public static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(a, b, c));
        }

        arr = new int[v+1];
        for(int i=0; i<=v; i++){
            arr[i] = i;
        }

        int cnt = 0;
        int answer = 0;
        while(cnt<v-1){
            Edge now = pq.poll();
            if(find(now.s)!=find(now.e)) {
                union(now.s, now.e);
                cnt++;
                answer += now.v;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
