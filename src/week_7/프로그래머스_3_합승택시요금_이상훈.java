package week_7;

import java.util.*;

class 프로그래머스_3_합승택시요금_이상훈 {

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] graph = new int[n][n];
        final int INF = 1000000000;

        // 그래프 초기화
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j)
                    graph[i][j] = INF;
            }
        }
        for(int[] fare : fares){
            graph[fare[0]-1][fare[1]-1] = Math.min(graph[fare[0]-1][fare[1]-1], fare[2]);
            graph[fare[1]-1][fare[0]-1] = Math.min(graph[fare[1]-1][fare[0]-1], fare[2]);
        }

        // 플로이드 와셜 알고리즘 수행
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    graph[j][k] = Math.min(graph[j][k], graph[j][i]+graph[i][k]);
                }
            }
        }

        int minValue = INF;
        for(int i=0; i<n; i++){
            if(graph[i][s-1]==INF || graph[i][a-1]==INF || graph[i][b-1]==INF)
                continue;
            minValue = Math.min(minValue, graph[i][s-1] + graph[i][a-1] + graph[i][b-1]);
        }

        return minValue;
    }
}