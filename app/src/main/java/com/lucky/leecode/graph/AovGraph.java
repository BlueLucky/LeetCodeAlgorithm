package com.lucky.leecode.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 网络拓扑排序
 *
 * 1、 计算出各个顶点的入度
 * 2、 入度为0的结点入队
 * 3、入队结点的邻接点入度-1
 * 4、重复2-3步骤
 */
public class AovGraph {
    private int size;
    private String[] nodes;
    private int[][] edges;

    private String[] path;
    //存储图的入度
    private int[] eSize;
    //最早开始时间
    private int[] earlyFast;
    //最晚施工时间
    private int[]  lasts;
    public AovGraph(){
        init();
        eSize = new int[size];
        earlyFast = new int[size];
        lasts = new int[size];
    }

    public void findKeys(){
        int[] path = getPath();
        int start = path[0];
        int end = path[size-1];
        earlyFast(start);
        //初始化成工程最大值
        for(int i=0;i<size;i++){
            lasts[i] = earlyFast[end];
        }
        last(end);
        for (int i=0;i<size;i++){
            int node = path[i];
            if (earlyFast[node] == lasts[node]){
                System.out.print("--->"+nodes[node]);
            }
        }

        System.out.println();
    }

    public void last(int node){
        for (int i=0;i<size;i++){
            if(edges[i][node]>0){
                int last = lasts[node]-edges[i][node];
                System.out.println("lasts["+node+"]:"+lasts[node]+", last:"+last);
                if(last<lasts[i]){
                    lasts[i] = last;
                    last(i);
                }
            }
        }
    }

    /**
     * 最早施工时间
     * @param node
     */
    public void earlyFast(int node){
        for (int i=0;i<size;i++){
            if(edges[node][i]>0){
                int fast = earlyFast[node]+edges[node][i];
                if(fast>earlyFast[i]){
                    earlyFast[i] = fast;
                    earlyFast(i);
                }
            }
        }
    }

    /**
     * 计算图的入度
     */
    public void calGraphPenetration(){
        for (int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(edges[i][j]>0){
                    eSize[j]++;
                }
            }
        }
    }
    /**
     * 拓扑排序
     *
     * @return
     */
    public int[] getPath(){
        int index =0;
        int[] path = new int[size];
        //入度为0的结点添加到队列中
        Queue<Integer> queue = new LinkedList<>();
        //
        Stack<Integer> stack = new Stack<>();

        for (int i=0;i<size;i++){
            if(eSize[i]==0){
                queue.offer(i);
                stack.push(i);
            }
        }
        //入队结点的邻接点入度-1
        while (!stack.empty()){
            int node = stack.pop();
            path[index++] = node;
            for (int i=-0;i<size;i++){
                if(edges[node][i]>0){
                    eSize[i]--;
                    if(eSize[i]==0){
                        queue.offer(i);
                        stack.push(i);
                    }
                }
            }
        }
        return path;
    }

    private void init() {
        nodes = new String[]{"AA", "A", "B", "C", "D", "E", "F", "G", "H", "M", "K", "N"};
        //节点编号-常量
        final int AA = 0, A = 1, B = 2, C = 3, D = 4, E = 5, F = 6, G = 7, H = 8, M = 9, K = 10, N = 11;
        size = nodes.length;
        edges = new int[size][size];
        edges[AA][A] = 3;
        edges[AA][B] = 2;
        edges[AA][C] = 5;
        edges[A][D] = 4;
        edges[B][G] = 2;
        edges[B][E] = 3;
        edges[C][E] = 2;
        edges[C][F] = 3;
        edges[D][G] = 1;
        edges[E][K] = 1;
        edges[E][M] = 8;
        edges[F][K] = 4;
        edges[G][H] = 2;
        edges[H][M] = 3;
        edges[K][N] = 2;
        edges[M][N] = 3;
    }
}
