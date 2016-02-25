package com.example.test.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by parimal.patel on 24/02/16.
 */
public class Queue {
    private java.util.Queue queue = new LinkedBlockingQueue();

    public void push(Object obj){
        queue.offer(obj);
    }

    public int size(){
        return queue.size();
    }

    public Object fetch(){
        return queue.poll();
    }
}
