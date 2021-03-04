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
     * @param time  The object to take UTC time
     * @return the minutes of UTC time
     */
    @Override
    public int utcMinutes(OffsetDateTime time) {
        return time.getMinute();
    }
}
