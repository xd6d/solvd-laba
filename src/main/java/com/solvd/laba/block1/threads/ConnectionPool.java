package com.solvd.laba.block1.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConnectionPool {
    private volatile static ConnectionPool instance;
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private final Queue<Connection> connections = new ConcurrentLinkedQueue<>();

    private ConnectionPool(int size) {
        for (int i = 0; i < size; i++) {
            connections.add(new Connection());
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool(5);
        }
        return instance;
    }

    public synchronized Connection getConnection() {
        Connection connection = connections.poll();
        while (connection == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                LOGGER.error(e.getMessage());
            }
            connection = connections.poll();
        }
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        connections.add(connection);
        notify();
    }
}
