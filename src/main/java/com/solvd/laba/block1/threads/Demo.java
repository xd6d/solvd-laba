package com.solvd.laba.block1.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    private static final Logger LOGGER = LogManager.getLogger(Demo.class);

    public static void main(String[] args) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 7; i++) {
            executorService.execute(() -> {
                LOGGER.info("Starting thread, getting connection");
                Connection connection = connectionPool.getConnection();
                LOGGER.info("Got connection, doing some work");
                try {
                    Thread.sleep(13000);
                } catch (InterruptedException e) {
                    LOGGER.error(e.getMessage());
                }
                LOGGER.info("Work is done, releasing connection");
                connectionPool.releaseConnection(connection);
            });
        }
        executorService.shutdown();
    }
}
