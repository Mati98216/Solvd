package com.solvd.laba.task5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        int poolSize = 5;
        ConnectionPool pool = new ConnectionPool(poolSize);

        ExecutorService executor = Executors.newFixedThreadPool(7);
        CountDownLatch latch = new CountDownLatch(7);

        for (int i = 0; i < 5; i++) {
            CompletableFuture.runAsync(() -> {
                try {
                    Connection connection = pool.getConnection();
                    Thread.sleep(2000);
                    pool.releaseConnection(connection);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            }, executor);
        }

        for (int i = 0; i < 2; i++) {
            CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(1000);
                    Connection connection = pool.getConnection();
                    Thread.sleep(2000);
                    pool.releaseConnection(connection);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            }, executor);
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}