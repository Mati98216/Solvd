package com.solvd.laba.task5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

class ConnectionPool {
    private final int poolSize;
    private final BlockingQueue<Connection> connections;
    private final AtomicInteger currentConnections = new AtomicInteger(0);
    private static final Logger logger = Logger.getLogger(ConnectionPool.class.getName());

    public ConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        this.connections = new LinkedBlockingQueue<>(poolSize);
    }

    public Connection getConnection() throws InterruptedException {
        Connection connection = connections.poll();

        if (connection != null) {
            logger.info("Acquired Connection ID: " + connection.getConnectionId());
            return connection;
        } else {
            if (currentConnections.get() < poolSize) {
                synchronized (connections) {
                    if (currentConnections.get() < poolSize) { // Double-check to prevent exceeding pool size
                        connection = createConnection();
                        currentConnections.incrementAndGet();
                        logger.info("Created new Connection ID: " + connection.getConnectionId());
                        return connection;
                    }
                }
            }
            // Wait for a connection to be available
            connection = connections.take(); // Blocking call until a connection is available
            logger.info("Acquired Connection ID: " + connection.getConnectionId());
            return connection;
        }
    }

    public void releaseConnection(Connection connection) {
        connections.offer(connection);
        logger.info("Released Connection ID: " + connection.getConnectionId());
    }

    private Connection createConnection() {
        int newConnectionId = currentConnections.incrementAndGet();
        return new Connection(newConnectionId);
    }

    public int getCurrentConnections() {
        return currentConnections.get();
    }
}