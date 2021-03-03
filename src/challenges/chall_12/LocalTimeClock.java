package challenges.chall_12;

import java.time.LocalDateTime;

public class LocalTimeClock {

    /**
     * Get hour from object
     *
     * @param time  The object to take local time from
     * @return an hour in integer
     */
    private int hour(LocalDateTime time) {
        return time.getHour();
    }
    /**
     * Get minutes from object
     *
     * @param time  The object to take local time from
     * @return the minutes in integer accomplish
     */
    private int minutes(LocalDateTime time) {
        return time.getMinute();
    }

    /**
     * Calculate seconds as a float from an object
     *
     * @param time  The object to take local seconds
     * @return a float number with seconds
     */
    private float seconds(LocalDateTime time) {
        float seconds = time.getSecond();
        float fraction = time.getNano() / 1_000000000f;
        return seconds + fraction;
    }
}
