package com.lucky.leecode;

import com.lucky.leecode.link.LinkAlgorithm;
import com.lucky.leecode.link.ListNode;

import org.junit.Test;

public class LinkUnitTest {

    @Test
    public void deleteDuplicates(){
        LinkAlgorithm linkAlgorithm = new LinkAlgorithm();
        //[1,1,2]
        linkAlgorithm.printLink(linkAlgorithm.deleteDuplicates(linkAlgorithm.createListNode(new int[]{1,1,2})));
        //[1,1,2,3,3]
        linkAlgorithm.printLink(linkAlgorithm.deleteDuplicates(linkAlgorithm.createListNode(new int[]{1,1,2,3,3})));
        //[]
        linkAlgorithm.printLink(linkAlgorithm.deleteDuplicates(linkAlgorithm.createListNode(new int[]{})));
    }

    @Test
    public void testReverseList(){
        LinkAlgorithm linkAlgorithm = new LinkAlgorithm();
        //[1,2,3,4,5]
        linkAlgorithm.printLink(linkAlgorithm.reverseList(linkAlgorithm.createListNode(new int[]{1,2,3,4,5})));
        //[1,2,3,4,5]
        linkAlgorithm.printLink(linkAlgorithm.reverseList(linkAlgorithm.createListNode(new int[]{1,2})));
        //[]
        linkAlgorithm.printLink(linkAlgorithm.reverseList(linkAlgorithm.createListNode(new int[]{})));
    }

    /**
     * 移除链表测试
     */
    @Test
    public void removeElements() {
        LinkAlgorithm linkAlgorithm = new LinkAlgorithm();
        //1, 2, 6, 3, 4, 5, 6
        createRemoveTest(linkAlgorithm,new int[]{1, 2, 6, 3, 4, 5, 6},6);
        //[]
        createRemoveTest(linkAlgorithm,new int[]{},1);
        //[7,7,7,7]
        createRemoveTest(linkAlgorithm,new int[]{7,7,7,7},7);
    }

    private void createRemoveTest(LinkAlgorithm linkAlgorithm,int[] arr,int key) {
        ListNode head = linkAlgorithm.createListNode(arr);
        linkAlgorithm.printLink(head);
        ListNode result = linkAlgorithm.removeElements(head, key);
        linkAlgorithm.printLink(result);
    }
}
