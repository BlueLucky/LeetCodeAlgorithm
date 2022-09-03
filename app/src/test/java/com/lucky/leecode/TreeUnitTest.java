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

    @Test
    public void testHasPathSum(){
        TreeAlgorithm treeAlgorithm = new TreeAlgorithm();
        boolean hasPathSum = treeAlgorithm.hasPathSum(treeAlgorithm.createTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1}),22);
        System.out.println("hasPathSum:"+hasPathSum);

        boolean hasPathSum1 = treeAlgorithm.hasPathSum(treeAlgorithm.createTree(new Integer[]{1,2,3}),5);
        System.out.println("hasPathSum1:"+hasPathSum1);

        boolean hasPathSum2 = treeAlgorithm.hasPathSum(treeAlgorithm.createTree(new Integer[]{}),0);
        System.out.println("hasPathSum2:"+hasPathSum2);
    }

    @Test
    public void testSearchBST(){
        TreeAlgorithm treeAlgorithm = new TreeAlgorithm();
        TreeNode test1 = treeAlgorithm.searchBST(treeAlgorithm.createTree(new Integer[]{4,2,7,1,3}),2);
        treeAlgorithm.printTree(test1);

        TreeNode test2 = treeAlgorithm.searchBST(treeAlgorithm.createTree(new Integer[]{4,2,7,1,3}),5);
        treeAlgorithm.printTree(test2);
    }

    @Test
    public void testInsertSBT(){
        TreeAlgorithm treeAlgorithm = new TreeAlgorithm();
        TreeNode test1 = treeAlgorithm.insertIntoBST(treeAlgorithm.createTree(new Integer[]{4,2,7,1,3}),5);
        treeAlgorithm.printTree(test1);

        TreeNode test2 = treeAlgorithm.insertIntoBST(treeAlgorithm.createTree(new Integer[]{40,20,60,10,30,50,70}),25);
        treeAlgorithm.printTree(test2);
    }
}
