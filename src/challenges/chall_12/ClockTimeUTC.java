package challenges.chall_12;

import java.time.OffsetDateTime;

class ClockTimeUTC implements ClockUTC{

    /**
     * Get hour from ZonedDateTime
     *
     * @param time  The object to take UTC time
     * @return an hour of UTC time
     */
    @Override
    public int utcHours(OffsetDateTime time) {
        return time.getHour();
    }

    /**
     * Get minutes from ZonedDateTime
     *
     * @param time  The object to take UTC time minutes
     * @return the minutes of UTC time
     */
    @Override
    public int utcMinutes(OffsetDateTime time) {
        return time.getMinute();
    }

    /**
     * Calculate seconds as a float from an object
     *
     * @param time  The object to take UTC time seconds
     * @return a float number with seconds
     */
    @Override
    public float utcSeconds(OffsetDateTime time) {
        float seconds = time.getSecond();
        float fraction = time.getNano() / 1_000000000f;
        return seconds + fraction;
    }
}
