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
}
