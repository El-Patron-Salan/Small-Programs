package challenges.chall_12;

import java.time.LocalDateTime;

interface LocalClock {

    String showActualDate(LocalDateTime date);
    int localHours(LocalDateTime time);
    int localMinutes(LocalDateTime time);
    float localSeconds(LocalDateTime time);

}
