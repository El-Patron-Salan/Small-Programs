package challenges.chall_12;

import java.time.ZonedDateTime;

public interface ClockUTC {

    int utcHours(ZonedDateTime time);
    int utcMinutes(ZonedDateTime time);
    int utcSeconds(ZonedDateTime time);
}
