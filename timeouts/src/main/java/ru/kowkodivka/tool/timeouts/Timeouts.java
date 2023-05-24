package ru.kowkodivka.tool.timeouts;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Timeouts implements TimeoutProvider {
    private final Map<String, Map<String, Instant>> timeouts = new HashMap<>();

    @Override
    public void setTimeout(String playerId, String command, Duration duration) {
        Instant expirationTime = Instant.now().plus(duration);
        timeouts.computeIfAbsent(playerId, k -> new HashMap<>()).put(command, expirationTime);
    }

    @Override
    public boolean isTimeoutExpired(String playerId, String command) {
        Map<String, Instant> playerTimeouts = timeouts.get(playerId);
        if (playerTimeouts == null) return true;

        Instant expirationTime = playerTimeouts.get(command);
        if (expirationTime == null) return true;

        if (Instant.now().isAfter(expirationTime)) {
            timeouts.remove(playerId);
            return true;
        }

        return false;
    }
}
