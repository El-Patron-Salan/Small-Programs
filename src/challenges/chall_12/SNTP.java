package challenges.chall_12;

import java.time.ZoneOffset;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class SNTP {

    public static void main(String[] args) {

        //initialized objects
        LocalDateTime localComputerTime = LocalDateTime.now();
        OffsetDateTime utcDateTime = OffsetDateTime.now(ZoneOffset.UTC);


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
        System.out.print(localClockObj.showActualDate(localComputerTime));
        compareHoursMinutes(localHour, localMinute, utcHour, utcMinute);
        compareSeconds(localSeconds, utcSeconds);
        wantsDescription();
    }

    /**
     * Compares seconds and minutes between local and UTC clocks
     *
     * @param localHours    The integer with hour of local
     * @param localMinutes  The integer with minute of local
     * @param utcHours  The integer with hour of UTC
     * @param utcMinutes    The integer with minute of UTC
     */
    private static void compareHoursMinutes(int localHours, int localMinutes,
                                              int utcHours, int utcMinutes) {

        int compareHours = utcHours - localHours;
        int compareMinutes = utcMinutes - localMinutes;

        if(compareHours > 0) {
            System.out.printf("   (+%03d%02d)", compareHours, compareMinutes);
        }
        else {
            System.out.printf("   (%03d%02d)", compareHours, compareMinutes);
        }
    }

    /**
     * Compares seconds between local and UTC clocks
     *
     * @param localSeconds  The float with local seconds
     * @param utcSeconds    The float with UTC seconds
     */
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

    /**
     * Provide short description of program
     */
    private static void wantsDescription() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDo you want to see description (Y/N)  ");
        char yup = scanner.next().charAt(0);
        if(yup == 'Y' || yup == 'y') {
            new Description();
        }
    }
}
