package com.xima.thread.practice.thread_demo.stop_thread;

import java.util.concurrent.BlockingQueue;

class Consumer {
    BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    public boolean needMoreNums() {
        if (Math.random() > 0.97) {
            return false;
        }
        return true;
    }
}