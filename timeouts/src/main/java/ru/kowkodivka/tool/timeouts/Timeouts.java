package ru.kowkodivka.tool.timeouts;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Timeouts is a class that implements the TimeoutProvider interface and provides methods for managing timeouts for player commands.
 */
public class Timeouts implements TimeoutProvider {
    private final Map<String, Map<String, Instant>> timeouts = new HashMap<>();

    /**
     * Sets a timeout for a specific player and command.
     *
     * @param playerId the ID of the player
     * @param command  the command for which the timeout is set
     * @param duration the duration of the timeout
     */
    @Override
    public void setTimeout(String playerId, String command, Duration duration) {
        Instant expirationTime = Instant.now().plus(duration);
        timeouts.computeIfAbsent(playerId, k -> new HashMap<>()).put(command, expirationTime);
    }

    /**
     * Checks if the timeout for a specific player and command has expired.
     * If the timeout has expired, it is removed from the timeout map.
     *
     * @param playerId the ID of the player
     * @param command  the command for which the timeout is checked
     * @return true if the timeout has expired, false otherwise
     */
    @Override
    public boolean isTimeoutExpired(String playerId, String command) {
        Map<String, Instant> playerTimeouts = timeouts.get(playerId);
        if (playerTimeouts == null) {
            return true;
        }

        Instant expirationTime = playerTimeouts.get(command);
        if (expirationTime == null) {
            return true;
        }

        if (Instant.now().isAfter(expirationTime)) {
            timeouts.remove(playerId);
            return true;
        }

        return false;
    }
}

