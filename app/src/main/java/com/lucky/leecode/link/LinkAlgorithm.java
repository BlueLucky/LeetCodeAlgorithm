package com.lucky.leecode.link;

import java.util.Stack;

/**
 * 链表相关的算法
 */
public class LinkAlgorithm {
    /**
     * 环形链表
     *
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     *
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
     * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 注意：pos 不作为参数进行传递。仅仅是为了标识链表的实际情况。
     * 如果链表中存在环，则返回 true 。 否则，返回 false 。
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode lowPoint = head;
        ListNode fastPoint= head;
        while (fastPoint!=null&&fastPoint.next!=null){
            lowPoint = lowPoint.next;
            fastPoint = fastPoint.next.next;
            if(lowPoint==fastPoint){
                return true;
            }
        }
        return false;
    }


    /**
     * 回文链表
     *
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode node = head;
        Stack<Integer> stack = new Stack<>();
        while (node!=null){
            stack.push(node.val);
            node = node.next;
        }
        while (head!=null){
            if(head.val!=stack.pop()){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 合并两个有序链表
     *
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergerNode = new ListNode();
        if(list1==null&&list2==null){
            return null;
        }
        if(list1!=null&&list2==null){
            return list1;
        }
        if(list1==null&&list2!=null){
            return list2;
        }
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    ListNode temp = list1;
                    list1 = list1.next;
                    insertNode(mergerNode,temp);
                } else {
                    ListNode temp = list2;
                    list2 = list2.next;
                    insertNode(mergerNode,temp);
                }
            }else if(list1!=null){
                ListNode temp = list1;
                list1 = list1.next;
                insertNode(mergerNode,temp);
            }else if(list2!=null){
                ListNode temp = list2;
                list2 = list2.next;
                insertNode(mergerNode,temp);
            }
        }
        return mergerNode.next;
    }

    private void insertNode(ListNode sourNode,ListNode orgNode){
        ListNode lastNode = null;
        while (sourNode!=null){
            lastNode = sourNode;
            sourNode = sourNode.next;
        }

        if(lastNode!=null){
            lastNode.next = orgNode;
            orgNode.next = null;
        }
    }


    /**
     * 删除链表的倒数第N个节点
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int deletePosition = length(head) - n;
        System.out.println("deletePosition:" + deletePosition);
        if (deletePosition == 0) {
            return head.next;
        }
        ListNode deleteNode = head;
        for (int i = 0; i < deletePosition - 1; i++) {
            deleteNode = deleteNode.next;
        }
        deleteNode.next = deleteNode.next.next;
        return head;
    }
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

    private int length(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}
