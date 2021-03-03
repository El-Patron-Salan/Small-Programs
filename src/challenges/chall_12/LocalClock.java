package challenges.chall_12;

import java.time.LocalTime;

interface LocalClock {

    int localHours(LocalTime time);
    int localMinutes(LocalTime time);
    float localSeconds(LocalTime time);
}
