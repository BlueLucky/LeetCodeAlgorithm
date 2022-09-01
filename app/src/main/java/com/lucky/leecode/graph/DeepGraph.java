package com.lucky.leecode.graph;

import java.util.ArrayList;
import java.util.List;

public class DeepGraph {
    private String[] nodes;
    private int size;
    private int[][] edges;
    private int[] visit; //遍历标志，防止死循环

    public DeepGraph(){
        nodes = new String[]{"A","B","C","D","E","F","G"};
        size = nodes.length;
        visit = new int[size];
        queue = new int[size];

        final int A=0,B=1,C=2,D=3,E=4,F=5,G=6;
        edges = new int[size][size];
        edges[A][C] = 1;
        edges[A][D] = 1;
        edges[A][F] = 1;
        edges[B][C] = 1;
        edges[C][A] = 1;
        edges[C][B] = 1;
        edges[C][D] = 1;
        edges[D][A] = 1;
        edges[D][C] = 1;
        edges[E][G] = 1;
        edges[F][A] = 1;
        edges[F][G] = 1;
        edges[G][F] = 1;
        edges[G][E] = 1;
    }

    /**
     * 深度有限遍历
     */
    public void deepFirst(int start){
        visit[start] = 1;
        System.out.println("visit:"+this.nodes[start]);
        //找出start的邻接结点
        for(int i=0;i<this.size;i++){
            //start->i 的边都有
            if(edges[start][i]==1&&visit[i]==0){
                // 邻接点
                deepFirst(i);
            }
        }
    }

    /**
     * 广度有限算法
     *
     * 广度优先搜索遍历图的过程中以v 为起始点，由近至远，
     * 依次访问和v 有路径相通且路径长度为1,2,…的顶点
     *
     * @param start 起始遍历位置
     */
    private int[] queue;
    public void spanFirst(int head,int tail){
        int last = tail;
        for (int index=head;index<=tail;index++){
            int node = queue[index];
            System.out.println("visit:"+this.nodes[node]);
            for (int i=0;i<size;i++){
                if(edges[node][i]==1&&visit[i]==0){
                    visit[node] = 1;
                    if(!isInQueue(i)){
                        queue[++last] = i;
                    }
                }
            }
        }
        if(last>tail){
            spanFirst(tail+1,last);
        }
    }

    private boolean isInQueue(int node){
        for (int i=0;i<queue.length;i++){
            if(queue[i]==node){
                return true;
            }
        }
        return false;
    }

    public void spanFirst(int start){
        queue[0] = start;
        visit[start] = 1;
        spanFirst(0,0);
    }

    public void spanFirst(List<Integer> spansPonit){
        List<Integer> findPoints=new ArrayList<>();
        for (Integer span:spansPonit){
            visit[span] = 1;
            System.out.println("visit:"+this.nodes[span]);
            for (int i=0;i<size;i++){
                if(edges[span][i]==1&&visit[i]==0){
                    findPoints.add(i);
                }
            }
        }
        if(findPoints.size()>0){
            spanFirst(findPoints);
        }
    }
}
