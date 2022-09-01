package com.lucky.leecode;

import com.lucky.leecode.bloom.BloomFilterDemo;
import com.lucky.leecode.graph.AovGraph;
import com.lucky.leecode.graph.DeepGraph;
import com.lucky.leecode.graph.DijkstraGraph;
import com.lucky.leecode.tree.HuffmanTree;
import com.lucky.leecode.tree.Node;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
//        List<Node> nodes = new ArrayList<>();
//        nodes.add(new Node("a",10));
//        nodes.add(new Node("b",15));
//        nodes.add(new Node("c",12));
//        nodes.add(new Node("d",3));
//        nodes.add(new Node("e",4));
//        nodes.add(new Node("f",13));
//        nodes.add(new Node("g",1));
//
//        Node root = HuffmanTree.createTree(nodes);
//        HuffmanTree.printTree(root);
//        DeepGraph g = new DeepGraph();
//        g.spanFirst(0);

//        DijkstraGraph d = new DijkstraGraph();
//        d.search(0);
//        AovGraph graph = new AovGraph();
//        graph.calGraphPenetration();
//        int[] paths = graph.getPath();
//
//        graph.findKeys();

//        BloomFilterDemo demo = new BloomFilterDemo();
//        demo.createBloomFilter();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("biSearch:" + biSearch(null, 23));
    }

    public int biSearch(int[] arr, int skey) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < skey) {
                start = mid + 1;
            } else if (arr[mid] > skey) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}