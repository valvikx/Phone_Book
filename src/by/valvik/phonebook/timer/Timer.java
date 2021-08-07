package by.valvik.phonebook.timer;

import java.time.Duration;

import static java.lang.System.currentTimeMillis;
import static java.time.Duration.ofMillis;

public class Timer {

    private long startTime;

    private Duration duration;

    public void start() {

        startTime = currentTimeMillis();

    }

    public void finish() {

        duration = ofMillis(currentTimeMillis() - startTime);

    }

    public long toMillis() {

        return duration.toMillis();

    }

    public void setNewDuration(long millis) {

        duration = ofMillis(millis);

    }

    public void sumMillis(long first, long second) {

        duration = ofMillis(first + second);

    }

    public int getMinutes() {

        return duration.toMinutesPart();

    }

    public int getSeconds() {

        return duration.toSecondsPart();

    }

    public int getMillis() {

        return duration.toMillisPart();

    }

}
