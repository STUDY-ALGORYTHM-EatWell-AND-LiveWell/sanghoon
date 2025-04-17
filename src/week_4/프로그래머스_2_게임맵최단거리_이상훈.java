package week_4;
import java.util.*;

public class 프로그래머스_2_게임맵최단거리_이상훈 {

    public int solution(int[][] maps) {

        int row = maps.length;
        int col = maps[0].length;
        boolean[][] visited = new boolean[row][col];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            int cnt = pos[2];

            if(x==row-1 && y==col-1)
                return cnt;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=row || ny<0 || ny>=col)
                    continue;

                if(!visited[nx][ny] && maps[nx][ny]==1){
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, cnt+1});
                }
            }
        }

        return -1;
    }
}
