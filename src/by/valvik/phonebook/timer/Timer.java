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

    public Duration finish() {

        return ofMillis(currentTimeMillis() - startTime);

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

    public int getNanos() {

        return duration.toNanosPart();

    }

    public void setDuration(Duration duration) {

        this.duration = duration;

    }

}
