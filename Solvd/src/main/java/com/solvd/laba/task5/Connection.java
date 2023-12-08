package com.solvd.laba.task5;

// Mocked Connection class
class Connection {
    // Simulating some work
    public void executeQuery(String query) {
        System.out.println("Executing query: " + query);
    }

    // Simulating releasing the connection
    public void release() {
        System.out.println("Connection released.");
    }
}
