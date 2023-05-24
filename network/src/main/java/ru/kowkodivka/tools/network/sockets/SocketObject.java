package ru.kowkodivka.tools.network.sockets;


import java.io.IOException;

public interface SocketObject {
    void sendEvent(Object object);

    void connect() throws IOException;

    void disconnect();
}
