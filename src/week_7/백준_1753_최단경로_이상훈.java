package week_7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 백준_1753_최단경로_이상훈 {

    public static class Edge implements Comparable<Edge> {
        int vertex;
        int value;

        public Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Edge e) {
            return this.value - e.value;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for(int i=0; i<=V; i++){
            graph.add(new ArrayList<>());
        }

        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int K = Integer.parseInt(br.readLine());
        dist[K] = 0;
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(K, 0));

        while (!pq.isEmpty()){
            Edge now = pq.poll();
            int vertex = now.vertex;
            int value = now.value;

            for(Edge edge : graph.get(vertex)){
                if(value+edge.value<dist[edge.vertex]){
                    dist[edge.vertex] = value+ edge.value;
                    pq.offer(new Edge(edge.vertex, dist[edge.vertex]));
                }
            }
        }

        for(int i=1; i<=V; i++){
            if(dist[i]==Integer.MAX_VALUE)
                bw.write("INF\n");
            else
                bw.write(dist[i]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}