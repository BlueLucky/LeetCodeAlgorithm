package com.lucky.leecode.tree;

public class Node<E> {
    E data;
    int weight;
    Node leftChild;
    Node rightChild;
    public Node(E data,int weight){
        super();
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
