package com.lucky.leecode;

import com.lucky.leecode.queue.MyQueue;
import com.lucky.leecode.tree.TreeAlgorithm;
import com.lucky.leecode.tree.TreeNode;

import org.junit.Test;

import java.util.List;

public class TreeUnitTest {

    @Test
    public void testCreateTree(){
        TreeAlgorithm treeAlgorithm = new TreeAlgorithm();
        TreeNode treeNode = treeAlgorithm.createTree(new Integer[]{1,null,2,3});
        treeAlgorithm.printTree(treeNode);
    }

    @Test
    public void  testPreorderTraversal(){
        TreeAlgorithm treeAlgorithm = new TreeAlgorithm();
        List<Integer> result = treeAlgorithm.preorderTraversal(treeAlgorithm.createTree(new Integer[]{1,null,2,3}));
        for (Integer value:result){
            System.out.print(value);
        }
        System.out.println();

        List<Integer> result1 = treeAlgorithm.preorderTraversal(treeAlgorithm.createTree(new Integer[]{}));
        for (Integer value:result1){
            System.out.print(value);
        }
        System.out.println();

        List<Integer> result2 = treeAlgorithm.preorderTraversal(treeAlgorithm.createTree(new Integer[]{1}));
        for (Integer value:result2){
            System.out.print(value);
        }
        System.out.println();

    }
}
