package week_10;
import java.util.*;

public class 프로그래머스_2_후보키_이상훈 {

    class Solution {

        int row, col;
        String[][] relation;
        List<Set<Integer>> list = new ArrayList<>();

        public void dfs(Set<Integer> currentSet, int idx){

            if(idx == col){
                if(isUnique(currentSet))
                    list.add(new HashSet<>(currentSet));
                return;
            }

            currentSet.add(idx);
            dfs(currentSet, idx + 1);

            currentSet.remove(idx);
            dfs(currentSet, idx + 1);
        }

        public boolean isUnique(Set<Integer> set){

            Set<String> seen = new HashSet<>();
            for(int i = 0; i < row; i++){
                StringBuilder sb = new StringBuilder();
                for(int j : set){
                    sb.append(relation[i][j]).append(" ");
                }
                seen.add(sb.toString());
            }
            return seen.size() == row;
        }

        public int solution(String[][] relation) {
            this.row = relation.length;
            this.col = relation[0].length;
            this.relation = relation;

            dfs(new HashSet<>(), 0);

            Collections.sort(list, new Comparator<Set<Integer>>() {
                @Override
                public int compare(Set<Integer> o1, Set<Integer> o2) {
                    return o1.size()-o2.size();
                }
            });

            List<Set<Integer>> selected = new ArrayList<>();
            int answer = 0;

            for(Set<Integer> set : list){
                boolean flag = true;
                for(Set<Integer> sel : selected){
                    if(set.containsAll(sel)){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    selected.add(set);
                    answer++;
                }
            }

            return answer;
        }
    }
}
