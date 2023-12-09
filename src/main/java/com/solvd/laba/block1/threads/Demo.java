package com.solvd.laba.block1.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    private static final Logger LOGGER = LogManager.getLogger(Demo.class);

    public static void main(String[] args) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        int numberOfThreads = 7;
        Runnable runnable = () -> {
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
        };


//        doWithThreadPool(numberOfThreads, runnable);
        doWithCompletableFuture(numberOfThreads, runnable);


    }

    private static void doWithThreadPool(int numberOfThreads, Runnable runnable) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < numberOfThreads; i++) {
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }

    private static void doWithCompletableFuture(int numberOfThreads, Runnable runnable) {
        CompletableFuture<Void>[] completableFutures = new CompletableFuture[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            completableFutures[i] = CompletableFuture.runAsync(runnable);
        }
        CompletableFuture.allOf(completableFutures).join();
    }
}
