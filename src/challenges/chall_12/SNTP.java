package challenges.chall_12;

import java.time.LocalDateTime;

public class SNTP {

    /**
     * Get hour from object
     *
     * @param time  The object to take local time from
     * @return an hour in integer
     */
    private int getHour(LocalDateTime time) {
        return time.getHour();
    }
    /**
     * Get minutes from object
     *
     * @param time  The object to take local time from
     * @return the minutes in integer
     */
    private int getMinutes(LocalDateTime time) {
        return time.getMinute();
    }
}
