package com.lucky.leecode.stack;

/**
 *
 */
public class StackNode {
    public int val;
    public int min;
    public StackNode next;

    public StackNode(int val,int min,StackNode next){
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
