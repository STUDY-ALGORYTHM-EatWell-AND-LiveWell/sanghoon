package week_6;

public class 프로그래머스_3_파괴되지않은건물_이상훈 {

    public int solution(int[][] board, int[][] skill) {
        int row = board.length;
        int col = board[0].length;

        int[][] diff = new int[row+1][col+1];

        for(int[] tem : skill){
            int degree = (tem[0]==1) ? -tem[5] : tem[5];
            int r1 = tem[1];
            int c1 = tem[2];
            int r2 = tem[3];
            int c2 = tem[4];
            diff[r1][c1] += degree;
            diff[r2+1][c1] -= degree;
            diff[r1][c2+1] -= degree;
            diff[r2+1][c2+1] += degree;
        }

        // 세로 누적합
        for(int i=0; i<col; i++){
            for(int j=1; j<row; j++){
                diff[j][i] += diff[j-1][i];
            }
        }

        // 가로 누적합
        for(int i=0; i<row; i++){
            for(int j=1; j<col; j++){
                diff[i][j] += diff[i][j-1];
            }
        }

        // 파괴되지 않은 건물 개수 카운팅
        int cnt = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j]+diff[i][j]>0)
                    cnt++;
            }
        }

        return cnt;
    }
}
