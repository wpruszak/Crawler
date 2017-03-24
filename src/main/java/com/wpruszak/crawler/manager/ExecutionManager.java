package com.wpruszak.crawler.manager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 24.03.17.
 */
@Service
public class ExecutionManager {

    private final int maxThreads;

    private ExecutorService executorService;

    public ExecutionManager(@Value("${crawler.max.threads}") Integer maxThreads) {
        this.maxThreads = maxThreads;
        this.executorService = Executors.newFixedThreadPool(this.maxThreads);
    }

    public int getMaxThreads() {
        return this.maxThreads;
    }
}
