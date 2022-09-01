package com.lucky.leecode.queue;

import java.util.Stack;

/**
 * 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 * 1. void push(int x) 将元素 x 推到队列的末尾
 * 2. int pop() 从队列的开头移除并返回元素
 * 3. int peek() 返回队列开头的元素
 * 4. boolean empty() 如果队列为空，返回 true ；否则，返回 false
 */
public class MyQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        if(popStack.isEmpty()){
            return -1;
        }
        return popStack.pop();
    }

    public int peek() {
        if(empty()){
            return -1;
        }
        if(popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        if(popStack.isEmpty()){
            return -1;
        }
        return popStack.peek();
    }

    public boolean empty() {
        return pushStack.isEmpty()&&popStack.isEmpty();
    }
}
