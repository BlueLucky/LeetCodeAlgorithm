package com.lucky.leecode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 树的基本算法
 */
public class TreeAlgorithm {
    /**
     * 二叉树的最大深度
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点。
     *
     *  递归调用，统计子树的高度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = maxDepth(root.left)+1;
        int right = maxDepth(root.right)+1;
        return Math.max(left,right);
    }

    /**
     * 验证二叉搜索树
     *
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     *
     * 有效 二叉搜索树定义如下：
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBstRangle(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBstRangle(TreeNode root,long minValue,long maxVale){
        if(root==null){
            return true;
        }
        if(root.val>=maxVale||root.val<=minValue){
            return false;
        }
        return isValidBstRangle(root.left,minValue,root.val)&&isValidBstRangle(root.right,root.val,maxVale);
    }

    /**
     * 对称二叉树
     *
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     *           1
     *      2        2
     *
     *   3   4     4     3
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        treeReversal(root.left);
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        Queue<TreeNode> leftQueue = new LinkedList<>();
        leftQueue.offer(leftNode);
        Queue<TreeNode> rightQueue = new LinkedList<>();
        rightQueue.offer(rightNode);
        while (!leftQueue.isEmpty()||!rightQueue.isEmpty()){
            TreeNode lNode = leftQueue.poll();
            TreeNode rNode = rightQueue.poll();
            if(lNode!=null&&rNode==null){
                return false;
            }else if(lNode==null&&rNode!=null){
                return  false;
            }else {
                if(lNode!=null&&rNode!=null){
                    if(lNode.val!=rNode.val){
                        return false;
                    }else {
                        leftQueue.offer(lNode.left);
                        leftQueue.offer(lNode.right);
                        rightQueue.offer(rNode.left);
                        rightQueue.offer(rNode.right);
                    }
                }
            }
        }
        return true;
    }

    private void treeReversal(TreeNode treeNode){
        if(treeNode!=null){
            TreeNode leftNode = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = leftNode;

            treeReversal(treeNode.left);
            treeReversal(treeNode.right);
        }
    }
    /**
     * 二叉树的层序遍历
     *
     *  给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     *
     *         3
     *
     *     9        20
     *
     *            15     7
     *
     * 输出结果：[3] [9,20] [15,7]
     *
     * 思路：
     *  同步队添加树的遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            int size = nodes.size();
            List<Integer> subResult = new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode node = nodes.poll();
                subResult.add(node.val);
                if(node.left!=null){
                    nodes.offer(node.left);
                }
                if(node.right!=null){
                    nodes.offer(node.right);
                }
            }
            result.add(subResult);
        }
        return result;
    }

    /**
     * 将有序数组转换为二叉搜索树
     *
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     *
     * 思路：
     * 二分查找，寻找中心
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length<=0){
            return null;
        }
        return createMidTreeNode(nums,0,nums.length-1);
    }

    private TreeNode createMidTreeNode(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        System.out.println("createMidTreeNode mid:" + mid);
        if (mid < 0 || mid > nums.length - 1 || left > right) {
            return null;
        }
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createMidTreeNode(nums,left,mid-1);
        root.right = createMidTreeNode(nums,mid+1,right);
        return root;
    }

    /**
     * 二叉树的前序遍历
     *
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     *
     * 前序遍历：根节点→左子树→右子树
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node!=null){
                result.add(node.val);
                if(node.right!=null){
                    stack.push(node.right);
                }
                if(node.left!=null){
                    stack.push(node.left);
                }
            }
        }
        return result;
    }

    /**
     * 二叉树的中序遍历
     *
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     *
     * 中序遍历：左子树→根节点→右子树
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }

    /**
     * 二叉树的后序遍历
     *
     * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
     *
     * 后序遍历：左子树→右子树→根节点
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> reslut = new ArrayList<>();
        Stack<TreeNode> resultStack = new Stack<>();
        Stack<TreeNode> tempStack = new Stack<>();
        tempStack.push(root);
        while (!tempStack.isEmpty()){
            TreeNode node = tempStack.pop();
            resultStack.push(node);
            if(node.left!=null){
                tempStack.push(node.left);
            }
            if(node.right!=null){
                tempStack.push(node.right);
            }
        }
        while (!resultStack.isEmpty()){
            TreeNode node = resultStack.pop();
            if(node!=null){
                reslut.add(node.val);
            }
        }
        return reslut;
    }

    /**
     * 路径总和
     *
     * 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。
     * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
     * 如果存在，返回 true ；否则，返回 false 。
     *
     * 叶子节点 是指没有子节点的节点。
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {

        return false;
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
