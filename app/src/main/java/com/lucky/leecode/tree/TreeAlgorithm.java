package com.lucky.leecode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树的基本算法
 */
public class TreeAlgorithm {
    /**
     * 二叉树的前序遍历
     *
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     *
     * @param root
     * @return
     */
    //todo 明天继续
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        return result;
    }

    /**
     * 打印树
     *
     * @param root
     */
    public void printTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node!=null){
                System.out.println("node:"+node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
    }

    /**
     * 素组构建 tree
     *
     * @param arr
     * @return
     */
    public TreeNode createTree(Integer arr[]){
        if(arr==null||arr.length<=0){
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean isLeft = true;
        for (int i=1;i<arr.length;i++){
            TreeNode node = queue.peek();
            Integer value = arr[i];
            if(isLeft){
                if(value!=null){
                    node.left = new TreeNode(value);
                    queue.offer(node.left);
                }
                isLeft = false;
            }else {
                if(value!=null){
                    node.right = new TreeNode(value);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }
}
