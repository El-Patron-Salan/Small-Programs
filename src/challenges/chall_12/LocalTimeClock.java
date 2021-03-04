package challenges.chall_12;

import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LocalTimeClock implements LocalClock{

    /**
     * Output actual day in specified format
     *
     * @param date  The object to take date and time from
     * @return a String with specified format of date and time
     */
    @Override
    public String showActualDate(LocalDateTime date) {
        date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss.S [a]");
        return formatter.format(date);
    }

    /**
     * Get hour from object
     *
     * @param time  The object to take local time from
     * @return an hour in integer
     */
    @Override
    public int localHours(LocalTime time) {
        return time.getHour();
    }

    /**
     * Get minutes from object
     *
     * @param time  The object to take local time from
     * @return the minutes in integer accomplish
     */
    @Override
    public int localMinutes(LocalTime time) {
        return time.getMinute();
    }

    /**
     * Calculate seconds as a float from an object
     *
     * @param time  The object to take local seconds
     * @return a float number with seconds
     */
    @Override
    public float localSeconds(LocalTime time) {
        float seconds = time.getSecond();
        float fraction = time.getNano() / 1_000000000f;
        return seconds + fraction;
    }
}
