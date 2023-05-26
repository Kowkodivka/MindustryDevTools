package ru.kowkodivka.tool.timeouts;

import java.time.Duration;

/**
 * TimeoutProvider is an interface that provides methods for managing timeouts for player commands.
 */
public interface TimeoutProvider {
    /**
     * Sets a timeout for a specific player and command.
     *
     * @param playerId the ID of the player
     * @param command  the command for which the timeout is set
     * @param duration the duration of the timeout
     */
    void setTimeout(String playerId, String command, Duration duration);

    /**
     * Checks if the timeout for a specific player and command has expired.
     *
     * @param playerId the ID of the player
     * @param command  the command for which the timeout is checked
     * @return true if the timeout has expired, false otherwise
     */
    boolean isTimeoutExpired(String playerId, String command);
}

