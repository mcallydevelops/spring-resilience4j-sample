package com.mcallydevelops.springresilience4jsample;

import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@Service
public class SampleService {

    @TimeLimiter(name = "backendA")
    public CompletableFuture<String> timeLimiterTest() throws Exception {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(3000l);
            completableFuture.complete("Hello World!");
            return null;
        });

        return completableFuture;
    }
}
