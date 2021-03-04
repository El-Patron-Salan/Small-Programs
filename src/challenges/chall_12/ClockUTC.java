package challenges.chall_12;

import java.time.OffsetDateTime;

interface ClockUTC {

    int utcHours(OffsetDateTime time);
    int utcMinutes(OffsetDateTime time);
    int utcSeconds(OffsetDateTime time);

}
