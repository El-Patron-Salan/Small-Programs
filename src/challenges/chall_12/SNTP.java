package challenges.chall_12;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class SNTP {

    public static void main(String[] args) {

        //initialized objects
        LocalDateTime localComputerTime = LocalDateTime.now();
        OffsetDateTime utcDateTime = OffsetDateTime.now();


        //take specified values of local time
        LocalTimeClock localClockObj = new LocalTimeClock();
        //and UTC time
        ClockTimeUTC utcObj = new ClockTimeUTC();

        //initialized hours and minutes - local and UTC
        int localHour = localClockObj.localHours(localComputerTime);
        int localMinute = localClockObj.localMinutes(localComputerTime);
        int utcHour = utcObj.utcHours(utcDateTime);
        int utcMinute = utcObj.utcMinutes(utcDateTime);

        //initialized seconds for local and UTC
        float localSeconds = localClockObj.localSeconds(localComputerTime);
        float utcSeconds = utcObj.utcSeconds(utcDateTime);

        //output
        System.out.println(localClockObj.showActualDate(localComputerTime));
        compareHoursMinutes(localHour, localMinute, utcHour, utcMinute);
        compareSeconds(localSeconds, utcSeconds);
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

    private static void wantsDescription() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDo you want to see description (Y/N)  ");
        char yup = scanner.next().charAt(0);
        if(yup == 'Y' || yup == 'y') {
            Description desc = new Description();
        }
    }
}
