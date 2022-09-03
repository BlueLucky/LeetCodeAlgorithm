package com.lucky.leecode.stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 */

public class MinStack {
    private StackNode head;

    public MinStack() {
    }

    public void push(int val) {
        if (empty()) {
            head = new StackNode(val, val, null);
        }
        head = new StackNode(val, Math.min(head.min, val), head);
    }

    public void pop() throws Exception {
        if (empty()) {
            throw new Exception("");
        }
        head = head.next;
    }

    public int top() throws Exception {
        if (empty()) {
            throw new Exception("");
        }
        return head.val;
    }

    public int getMin() throws Exception {
        if (empty()) {
            throw new Exception("");
        }
        return head.min;
    }

    private boolean empty() {
        return head == null;
    }
}
