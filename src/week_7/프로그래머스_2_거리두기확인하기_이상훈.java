package week_7;

public class 프로그래머스_2_거리두기확인하기_이상훈 {

    public boolean dfs(int x, int y, char[][] graph, int cnt, int len, int initX, int initY){
        if(cnt==2)
            return true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0 || nx>=len || ny<0 || ny>=len || (nx==initX && ny==initY))
                continue;

            if(graph[nx][ny]=='O' && !dfs(nx, ny, graph, cnt+1, len, initX, initY))
                return false;

            else if(graph[nx][ny]=='P')
                return false;
        }
        return true;
    }

    public int[] solution(String[][] places) {
        final int len = 5;
        int[] answers = new int[len];

        for(int i=0; i<len; i++){
            String[] place = places[i];
            char[][] graph = new char[len][len];

            // 대기실 세팅
            for(int j=0; j<len; j++){
                for(int k=0; k<len; k++){
                    graph[j][k] = place[j].charAt(k);
                }
            }

            // dfs 탐색
            boolean result = true;
            outer:
            for(int j=0; j<len; j++){
                for(int k=0; k<len; k++){
                    if(graph[j][k]=='P' && !dfs(j, k, graph, 0, len, j, k)){
                        result =false;
                        break outer;
                    }
                }
            }
            answers[i] = result ? 1 : 0;
        }
        return answers;
    }
}
