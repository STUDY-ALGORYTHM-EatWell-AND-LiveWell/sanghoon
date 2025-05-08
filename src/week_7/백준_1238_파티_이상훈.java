package week_7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 백준_1238_파티_이상훈 {

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
    public static int N;
    public static int[] answers;

    public static void dijk(int X, List<List<Edge>> graph, int[] dist){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(X, 0));

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

        for(int i=1; i<=N; i++){
            answers[i] += dist[i];
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        List<List<Edge>> reverseGraph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        int[] dist = new int[N+1];
        int[] reverseDist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(reverseDist, Integer.MAX_VALUE);

        dist[X] = 0;
        reverseDist[X] = 0;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w));
            reverseGraph.get(v).add(new Edge(u, w));
        }

        answers = new int[N+1];
        dijk(X, graph, dist);
        dijk(X, reverseGraph, reverseDist);

        int maxValue = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++){
            maxValue = Math.max(maxValue, answers[i]);
        }

        bw.write(String.valueOf(maxValue));
        bw.flush();
        bw.close();
        br.close();
    }
}