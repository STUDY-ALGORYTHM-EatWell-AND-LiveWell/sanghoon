package week_4;
import java.util.*;

public class 프로그래머스_3_불량사용자_이상훈 {

    public void dfs(String[] userId, boolean[] isUserIdBanned, List<String> userIdList, String[] bannedId, int banIdx, HashSet<String> resultSet){

        // dfs 종료 조건, 결과값을 중복을 제거하여 저장
        if(banIdx==bannedId.length){
            StringBuilder sb = new StringBuilder();
            List<String> temList = new ArrayList<>(userIdList);
            Collections.sort(temList);

            for(String tem : temList){
                sb.append(tem);
            }

            resultSet.add(sb.toString());
            return;
        }

        for(int i=0; i<userId.length; i++){
            if(!isUserIdBanned[i] && isMatched(userId[i], bannedId[banIdx])){
                isUserIdBanned[i] = true;
                userIdList.add(userId[i]);
                dfs(userId, isUserIdBanned, userIdList, bannedId, banIdx+1, resultSet);
                isUserIdBanned[i] = false;
                userIdList.remove(userIdList.size()-1);
            }
        }

    }

    public boolean isMatched(String userId, String bannedId){
        if(userId.length() != bannedId.length())
            return false;

        for(int i=0; i<userId.length(); i++){
            if(bannedId.charAt(i)=='*')
                continue;

            if(bannedId.charAt(i)!=userId.charAt(i))
                return false;
        }
        return true;
    }

    public int solution(String[] userId, String[] bannedId) {
        boolean[] isUserIdBanned = new boolean[userId.length];
        List<String> userIdList = new LinkedList<>();
        HashSet<String> resultSet = new HashSet<>();

        dfs(userId, isUserIdBanned, userIdList, bannedId, 0, resultSet);

        return resultSet.size();
    }
}
