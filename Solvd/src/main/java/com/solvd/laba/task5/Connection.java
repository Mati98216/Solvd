package com.solvd.laba.task5;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class Connection {
    private int connectionId;

    public Connection(int id) {
        this.connectionId = id;
    }

    public void connect() {
        System.out.println("Connected to Connection ID: " + connectionId);
    }

    public void disconnect() {
        System.out.println("Disconnected Connection ID: " + connectionId);
    }
}

