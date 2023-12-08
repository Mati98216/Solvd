package com.solvd.laba.task5;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class CompletableFutureConnectionPool {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ConnectionPool pool = new ConnectionPool(5);

        // Creating the connection pool using CompletableFuture
        CompletableFuture<Void> initializationFuture = CompletableFuture.runAsync(pool::initialize);

        // Creating CompletableFutures to get connections
        CompletableFuture<Void>[] getConnectionFutures = new CompletableFuture[7];
        for (int i = 0; i < 7; i++) {
            getConnectionFutures[i] = CompletableFuture.runAsync(() -> {
                try {
                    Connection connection = pool.getConnection();
                    connection.executeQuery("SELECT * FROM table");
                    Thread.sleep(1000); // Simulating some work
                    pool.releaseConnection(connection);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Waiting for all tasks to complete
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(getConnectionFutures);
        allTasks.get(); // Blocking until all tasks complete
    }
}