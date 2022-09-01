package com.lucky.leecode.link;

import java.util.Stack;

/**
 * 链表相关的算法
 */
public class LinkAlgorithm {
    /**
     * 删除排序链表中的重复元素
     *
     * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        Stack<ListNode> nodes = new Stack<>();
        nodes.push(head);
        head = head.next;
        while (head!=null){
            ListNode node = nodes.peek();
            if(node.val!=head.val){
                nodes.push(head);
            }
            head = head.next;
        }
        ListNode result= null;
        while (!nodes.isEmpty()){
            ListNode node = nodes.pop();
            ListNode pre = result;
            result = node;
            result.next = pre;
        }
        return result;
    }

    /**
     * 反转链表
     *
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        while (head!=null){
            ListNode pre = result;
            result = head;
            head = head.next;

            result.next = pre;
        }
        return result;
    }

    /**
     * 移除链表元素
     *
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        ListNode deleteNode = head;
        ListNode preNode = head;

        while (deleteNode!=null){
            if(deleteNode.val==val){
                if(deleteNode==head){
                    head = head.next;
                    deleteNode = head;
                }else{
                    preNode.next = deleteNode.next;
                    deleteNode = deleteNode.next;
                }
            }else{
                preNode = deleteNode;
                deleteNode = deleteNode.next;
            }
        }
        return head;
    }

    public void printLink(ListNode node){
        ListNode printNode = node;
        while (printNode!=null){
            System.out.print(printNode.val+" ");
            printNode = printNode.next;
        }
        System.out.println();
    }

    /**
     * 创建link 链表
     *
     * @param arr
     * @return
     */
    public ListNode createListNode(int []arr){
        ListNode head = null;
        ListNode next = null;
        for(int i=0;i<arr.length;i++){
            if(head==null){
                head = new ListNode(arr[i]);
                next = head;
            }else {
                next.next = new ListNode(arr[i]);
                next = next.next;
            }
        }
        return head;
    }
}
