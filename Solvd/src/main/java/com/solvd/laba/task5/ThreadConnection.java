package com.solvd.laba.task5;

class ThreadConnection {
    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool(5);

        // Creating the connection pool using a thread
        Runnable connectionInitializer = pool::initialize;
        Thread initializationThread = new Thread(connectionInitializer);
        initializationThread.start();

        // Creating threads to get connections
        for (int i = 0; i < 7; i++) {
            Runnable getConnectionTask = () -> {
                try {
                    Connection connection = pool.getConnection();
                    connection.executeQuery("SELECT * FROM table");
                    Thread.sleep(1000); // Simulating some work
                    pool.releaseConnection(connection);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            Thread thread = new Thread(getConnectionTask);
            thread.start();
        }
    }
}