package ru.kowkodivka.tool.network.sockets;

import arc.Events;
import arc.net.Connection;
import arc.net.DcReason;
import arc.net.NetListener;
import arc.net.Server;

import java.io.IOException;

public class ServerSocket implements SocketObject {
    private final int port;
    private final boolean allowLocalAddresses;
    private final Server server;

    public ServerSocket(int port, boolean allowLocalAddresses) {
        this.port = port;
        this.allowLocalAddresses = allowLocalAddresses;
        this.server = new Server(32768, 16384, null);

        this.server.addListener(new ServerSocketListener(allowLocalAddresses));
    }

    public int getPort() {
        return port;
    }

    public Server getServer() {
        return server;
    }

    @Override
    public void sendEvent(Object object) {
        server.sendToAllTCP(object);
    }

    @Override
    public void connect() throws IOException {
        server.bind(port);
        server.start();
    }

    @Override
    public void disconnect() {
        server.close();
    }

    protected static class ServerSocketListener implements NetListener {
        private final boolean allowLocalAddresses;

        public ServerSocketListener(boolean allowLocalAddresses) {
            this.allowLocalAddresses = allowLocalAddresses;
        }

        @Override
        public void connected(Connection connection) {
            if (!connection.getRemoteAddressTCP().getAddress().isLoopbackAddress() && allowLocalAddresses) {
                connection.close(DcReason.closed);
            }
        }

        @Override
        public void received(Connection connection, Object object) {
            Events.fire(object);
        }
    }
}
