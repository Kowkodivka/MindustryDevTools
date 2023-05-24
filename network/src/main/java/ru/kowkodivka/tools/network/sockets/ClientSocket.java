package ru.kowkodivka.tools.network.sockets;

import arc.Events;
import arc.net.Client;
import arc.net.Connection;
import arc.net.NetListener;

import java.io.IOException;

public class ClientSocket implements SocketObject {
    private final int port;
    private final String remote;
    private final Client client;

    public ClientSocket(String remote, int port) {
        this.port = port;
        this.remote = remote;
        this.client = new Client(32768, 16384, null);

        this.client.addListener(new ClientSocketListener());
    }

    public int getPort() {
        return port;
    }

    public String getRemote() {
        return remote;
    }

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

    protected static class ClientSocketListener implements NetListener {
        @Override
        public void received(Connection connection, Object object) {
            Events.fire(object);
        }
    }
}
