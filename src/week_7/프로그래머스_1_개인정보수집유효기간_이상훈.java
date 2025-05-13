package week_7;
import java.util.*;

public class 프로그래머스_1_개인정보수집유효기간_이상훈 {

    public String calExpiredDate(String privacy, Map<Character, Integer> termInfo){
        int year = Integer.parseInt(privacy.substring(0, 4));
        int month = Integer.parseInt(privacy.substring(5, 7));
        int day = Integer.parseInt(privacy.substring(8, 10));
        int period = termInfo.get(privacy.charAt(11));

        // 하루 뺀 날짜 구하기
        day--;
        if(day==0){
            month--;
            if(month==0){
                year--;
                month = 12;
            }
            day = 28;
        }

        // 유효기간 더하기
        if((month+period)%12==0){
            year += (month+period)/12 -1;
            month = 12;
        }
        else{
            year += (month+period)/12;
            month = (month+period)%12;
        }

        // 문자열로 변환
        String newYear = String.valueOf(year);
        String newMonth = String.valueOf(month).length()==1 ? 0+String.valueOf(month) : String.valueOf(month);
        String newDay = String.valueOf(day).length()==1 ? 0+String.valueOf(day) : String.valueOf(day);

        StringBuilder sb = new StringBuilder();
        sb.append(newYear).append(".");
        sb.append(newMonth).append(".");
        sb.append(newDay);

        return sb.toString();
    }

    public int[] solution(String today, String[] terms, String[] privacies) {

        Map<Character, Integer> termInfo = new HashMap<>();
        for(String term : terms){
            termInfo.put(term.charAt(0), Integer.valueOf(term.substring(2, term.length())));
        }

        List<Integer> answers = new ArrayList<>();
        for(int i=1; i<=privacies.length; i++){
            String expiredDate = calExpiredDate(privacies[i-1], termInfo);

            if(today.compareTo(expiredDate)>0)
                answers.add(i);
        }

        return answers.stream().mapToInt(Integer::intValue).toArray();
    }
}
