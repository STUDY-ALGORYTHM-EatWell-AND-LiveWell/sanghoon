package week_6;

public class 프로그래머스_2_등굣길_이상훈 {

    public boolean isWater(int x, int y, int[][] puddles){
        for(int i=0; i<puddles.length; i++){
            if(puddles[i][0]==y && puddles[i][1]==x)
                return true;
        }
        return false;
    }

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        dp[0][1] = 1;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(isWater(i, j, puddles))
                    continue;
                dp[i][j] = (dp[i-1][j]+dp[i][j-1])%1000000007;
            }
        }
        return dp[n][m];
    }
}
