package ru.kowkodivka.tool.network.sockets;


import java.io.IOException;

/**
 * SocketObject is an interface that defines common methods for socket communication.
 */
public interface SocketObject {
    /**
     * Sends an event object over the socket connection.
     *
     * @param object the event object to send
     */
    void sendEvent(Object object);

    /**
     * Connects to the remote socket.
     *
     * @throws IOException if an I/O error occurs while connecting
     */
    void connect() throws IOException;

    /**
     * Disconnects from the socket.
     */
    void disconnect();
}

