package ru.kowkodivka.tool.network.sockets;

import arc.Events;
import arc.net.Connection;
import arc.net.DcReason;
import arc.net.NetListener;
import arc.net.Server;

import java.io.IOException;

/**
 * ServerSocket is a wrapper class for ARC Net's Server, providing simplified socket functionality
 * for binding to a port, accepting connections, sending events, and disconnecting from clients.
 */
public class ServerSocket implements SocketObject {
    private final int port;
    private final Server server;

    /**
     * Constructs a new ServerSocket with the specified port and whether to allow connections from local addresses.
     *
     * @param port                the port to bind the server socket to
     * @param allowLocalAddresses whether to allow connections from local addresses
     */
    public ServerSocket(int port, boolean allowLocalAddresses) {
        this.port = port;
        this.server = new Server(0, 0, null);

        this.server.addListener(new ServerSocketListener(allowLocalAddresses));
    }

    /**
     * Returns the port that the server socket is bound to.
     *
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * Returns the underlying ARC Net Server instance.
     *
     * @return the ARC Net Server
     */
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

    /**
     * Listener class to handle events related to the server socket.
     * Handles connection events and fires received objects as events using ARC Events system.
     */
    protected static class ServerSocketListener implements NetListener {
        private final boolean allowLocalAddresses;

        /**
         * Constructs a new ServerSocketListener with the specified flag for allowing connections from local addresses.
         *
         * @param allowLocalAddresses whether to allow connections from local addresses
         */
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

