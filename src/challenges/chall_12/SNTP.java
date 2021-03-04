package challenges.chall_12;

import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class SNTP {

    public static void main(String[] args) {

        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        OffsetDateTime utcDateTime = OffsetDateTime.now();

        //take specified values of local time
        LocalTimeClock local = new LocalTimeClock();
        //and UTC time
        ClockTimeUTC utc = new ClockTimeUTC();

        System.out.println(local.showActualDate(localDateTime));
    }

    private static void compareHoursMinutes(int localHours, int localMinutes,
                                              int utcHours, int utcMinutes) {

        int compareHours = utcHours - localHours;
        int compareMinutes = utcMinutes - localMinutes;

        if(compareHours > 0) {
            System.out.printf("\n+%02d%02d", compareHours, compareMinutes);
        }
        else if(utcHours == localHours) {
            System.out.println("0000");
        }
        else {
            System.out.printf("\n%02d%02d", compareHours, compareMinutes);
        }
    }
}
