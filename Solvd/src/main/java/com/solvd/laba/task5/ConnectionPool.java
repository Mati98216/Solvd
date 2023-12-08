package com.solvd.laba.task5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class ConnectionPool {
    private final int poolSize;
    private final BlockingQueue<Connection> connections;
    private final AtomicInteger currentConnections = new AtomicInteger(0);

    public ConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        this.connections = new LinkedBlockingQueue<>(poolSize);
    }

    public void initializePool() {
        for (int i = 0; i < poolSize; i++) {
            connections.add(new Connection(i + 1));
            currentConnections.incrementAndGet();
        }
    }

    public Connection getConnection() throws InterruptedException {
        Connection connection = connections.poll(5, TimeUnit.SECONDS);
        if (connection != null) {
            return connection;
        } else {
            throw new RuntimeException("Connection not available");
        }
    }

    public void releaseConnection(Connection connection) {
        connections.offer(connection);
    }

    public int getCurrentConnections() {
        return currentConnections.get();
    }
}
