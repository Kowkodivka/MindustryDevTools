package ru.kowkodivka.tool.network.sockets;

import arc.Events;
import arc.net.Client;
import arc.net.Connection;
import arc.net.NetListener;

import java.io.IOException;

/**
 * ClientSocket is a wrapper class for ARC Net's Client, providing simplified socket functionality
 * for connecting, sending events, and disconnecting from a remote server.
 */
public class ClientSocket implements SocketObject {
    private final int port;
    private final String remote;
    private final Client client;

    /**
     * Constructs a new ClientSocket with the specified remote address and port.
     *
     * @param remote the remote address to connect to
     * @param port   the port to connect to
     */
    public ClientSocket(String remote, int port) {
        this.port = port;
        this.remote = remote;
        this.client = new Client(0, 0, null);

        this.client.addListener(new ClientSocketListener());
    }

    /**
     * Returns the port used for the socket connection.
     *
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * Returns the remote address used for the socket connection.
     *
     * @return the remote address
     */
    public String getRemote() {
        return remote;
    }

    /**
     * Returns the underlying ARC Net Client instance.
     *
     * @return the ARC Net Client
     */
    public Client getClient() {
        return client;
    }

    @Override
    public void sendEvent(Object object) {
        if (!client.isConnected()) return;
        client.sendTCP(object);
    }

    @Override
    public void connect() throws IOException {
        client.start();
        client.connect(5000, remote, port);
    }

    @Override
    public void disconnect() {
        client.close();
    }

    /**
     * Listener class to handle received objects from the server.
     * Fires received objects as events using ARC Events system.
     */
    protected static class ClientSocketListener implements NetListener {
        @Override
        public void received(Connection connection, Object object) {
            Events.fire(object);
        }
    }
}

