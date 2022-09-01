package com.lucky.leecode;

import com.lucky.leecode.queue.MyQueue;

import org.junit.Test;

public class QueueUnitTest {

    @Test
    public void testCustomQueueByStack(){
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        int value = queue.peek();
        System.out.println("peek:"+value);
        queue.pop();
        System.out.println("isEmpty:"+queue.empty());
    }
}
