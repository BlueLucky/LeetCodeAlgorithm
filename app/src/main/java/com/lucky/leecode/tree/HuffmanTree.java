package com.lucky.leecode.tree;

import java.util.List;

public class HuffmanTree {
    /**
     * 哈夫曼树构造
     *
     * @param nodes
     * @return
     */
    public static Node createTree(List<Node> nodes){
        //每一次把权值最小的两个二叉树合并
        while(nodes.size()>1){
            //什么是最小的，list表进行排序，增序的方式， 0,1，
            sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            //生成一个新的节点（父节点），父节点的权重为两个子节点的之和
            Node parent = new Node(null,left.weight+right.weight);
            //树的连接
            parent.leftChild = left;
            parent.rightChild = right;
            nodes.remove(0);//删除最小的
            nodes.remove(0);//删除第二小的。
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 数据排序
     *
     * @param nodes
     */
    private static void sort(List<Node> nodes){
        if (nodes.size() <= 1)
            return ;
        /*循环数组长度的次数*/
        for (int i = 0; i < nodes.size(); i++){
            /*从第0个元素开始，依次和后面的元素进行比较
             * j < array.length - 1 - i表示第[array.length - 1 - i]
             * 个元素已经冒泡到了合适的位置，无需进行比较，可以减少比较次数*/
            for (int j = 0; j < nodes.size() - 1 - i; j++){
                /*如果第j个节点比后面的第j+1节点权重大，交换两者的位置*/
                if (nodes.get(j + 1).weight < nodes.get(j).weight) {
                    Node temp = nodes.get(j + 1);
                    nodes.set(j+1,nodes.get(j));
                    nodes.set(j,temp);
                }
            }
        }
    }
    /*

     * 递归打印哈夫曼树(先左子树，后右子树打印)
     */

    public static void printTree(Node root) {
        System.out.println(root.toString());
        if(root.leftChild !=null){
            System.out.print("left:");
            printTree(root.leftChild);
        }
        if(root.rightChild !=null){
            System.out.print("right:");
            printTree(root.rightChild);
        }
    }
}
