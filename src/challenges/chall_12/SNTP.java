package challenges.chall_12;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class SNTP {

    public static void main(String[] args) {

        //initialized objects
        LocalDateTime localComputerTime = LocalDateTime.now();
        OffsetDateTime utcDateTime = OffsetDateTime.now();


        //take specified values of local time
        LocalTimeClock local = new LocalTimeClock();
        //and UTC time
        ClockTimeUTC utc = new ClockTimeUTC();

        //initialized hours and minutes - local and UTC
        int localHour = local.localHours(localComputerTime);
        int localMinute = local.localMinutes(localComputerTime);
        int utcHour = utc.utcHours(utcDateTime);
        int utcMinute = utc.utcMinutes(utcDateTime);

        System.out.println(local.showActualDate(localComputerTime));
        compareHoursMinutes(localHour, localMinute, utcHour, utcMinute);

    }

    private static void compareHoursMinutes(int localHours, int localMinutes,
                                              int utcHours, int utcMinutes) {

        int compareHours = utcHours - localHours;
        int compareMinutes = utcMinutes - localMinutes;

        if(compareHours > 0) {
            System.out.printf("   (+%02d%02d)", compareHours, compareMinutes);
        }
        else if(utcHours == localHours) {
            System.out.print("   (0000)");
        }
        else {
            System.out.printf("   (%02d%02d)", compareHours, compareMinutes);
        }
    }

    private static void compareSeconds(float localSeconds, float utcSeconds) {

        float compare = utcSeconds - localSeconds;

        if(compare > 0) {
            System.out.printf("   +%f", compare);
        }
        else if(utcSeconds == localSeconds) {
            System.out.print("   00.00");
        }
        else {
            System.out.printf("   %f", compare);
        }
    }
}
