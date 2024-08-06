import java.time.*;

class Solution {
    public String solution(int a, int b) {
        LocalDate start = LocalDate.of(2016,1,1);
        LocalDate end = LocalDate.of(2016,a,b);
        long diff = Duration.between(start.atStartOfDay(),end.atStartOfDay()).toDays();
        Week[] days = Week.values();
        return days[(5+((int)diff%7))%7].name();
    }
    public enum Week {
        SUN,MON,TUE,WED,THU,FRI,SAT 
    }
}