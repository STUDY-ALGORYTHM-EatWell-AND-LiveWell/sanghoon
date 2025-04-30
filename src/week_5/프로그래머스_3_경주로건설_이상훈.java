package week_5;

public class 프로그래머스_3_경주로건설_이상훈 {

    public int answer = Integer.MAX_VALUE;

    public void dfs(int x, int y, int cost, int dir, int n, int[][] board, int[][][] dp){

        if(x==n-1 && y==n-1){
            answer = Math.min(answer, cost);
            return;
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || nx>=n || ny<0 || ny>=n)
                continue;
            if(board[nx][ny]==1)
                continue;

            if((dir==i || dir==-1) && (dp[nx][ny][i]==0 || dp[nx][ny][i] > cost+100)){
                dp[nx][ny][i] = cost+100;
                dfs(nx, ny, cost+100, i, n, board, dp);
            }
            else if(dir!=i && (dp[nx][ny][i]==0 || dp[nx][ny][i] > cost+600)){
                dp[nx][ny][i] = cost+600;
                dfs(nx, ny, cost+600, i, n, board, dp);
            }
        }
    }

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] dp = new int[n][n][4];

        dfs(0, 0, 0, -1, n, board, dp);
        return answer;
    }
}