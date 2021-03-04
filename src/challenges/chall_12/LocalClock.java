package challenges.chall_12;

import java.time.LocalDateTime;
import java.time.LocalTime;

interface LocalClock {

    String showActualDate(LocalDateTime date);
    int localHours(LocalTime time);
    int localMinutes(LocalTime time);
    float localSeconds(LocalTime time);

}
