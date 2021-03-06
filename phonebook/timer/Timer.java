package phonebook.timer;

import java.time.Duration;

public class Timer {

    private long startTime;

    private Duration duration;

    public void start() {

        startTime = System.currentTimeMillis();

    }

    public void finish() {

        duration = Duration.ofMillis(System.currentTimeMillis() - startTime);

    }

    public long toMillis() {

        return duration.toMillis();

    }

    public void setNewDuration(long millis) {

        duration = Duration.ofMillis(millis);

    }

    public void sumMillis(long first, long second) {

        duration = Duration.ofMillis(first + second);

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
