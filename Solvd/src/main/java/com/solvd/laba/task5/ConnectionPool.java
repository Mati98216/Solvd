package com.solvd.laba.task5;

import java.util.concurrent.*;

class ConnectionPool {
    private final int poolSize;
    private final BlockingQueue<Connection> connections;
    private volatile boolean initialized = false;

    public ConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        this.connections = new ArrayBlockingQueue<>(poolSize);
    }

    public void initialize() {
        if (!initialized) {
            for (int i = 0; i < poolSize; i++) {
                connections.offer(new Connection());
            }
            initialized = true;
        }
    }

    public Connection getConnection() throws InterruptedException {
        return connections.take();
    }

    public void releaseConnection(Connection connection) {
        connections.offer(connection);
    }
}