package ru.kowkodivka.tool.timeouts;

import java.time.Duration;

public interface TimeoutProvider {
    void setTimeout(String playerId, String command, Duration duration);

    boolean isTimeoutExpired(String playerId, String command);
}
