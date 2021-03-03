package challenges.chall_12;

import java.time.LocalTime;

class LocalTimeClock implements LocalClock{

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
