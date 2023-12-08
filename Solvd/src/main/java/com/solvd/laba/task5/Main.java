package com.solvd.laba.task5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int poolSize = 5;
        ConnectionPool pool = new ConnectionPool(poolSize);
        pool.initializePool();

        ExecutorService executor = Executors.newFixedThreadPool(7);
        CountDownLatch latch = new CountDownLatch(7);

        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                try {
                    Connection connection = pool.getConnection();
                    connection.connect();
                    Thread.sleep(2000); // Simulating some work with the connection
                    pool.releaseConnection(connection);
                    connection.disconnect();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }

        for (int i = 0; i < 2; i++) {
            executor.submit(() -> {
                try {
                    Thread.sleep(1000); // Simulating waiting for a connection
                    Connection connection = pool.getConnection();
                    connection.connect();
                    Thread.sleep(2000); // Simulating some work with the connection
                    pool.releaseConnection(connection);
                    connection.disconnect();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }

        try {
            latch.await(); // Wait for all threads to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}