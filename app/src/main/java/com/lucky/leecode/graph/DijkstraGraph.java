package com.lucky.leecode.graph;

public class DijkstraGraph {
    //结点数目
    private int size;
    //顶点信息
    private String[] nodes;
    //边信息
    private int[][] edges;
    //结点确认--中心标识
    private int[] isMarked;
    //源到结点的路径信息
    private String[] path;
    //源到结点的距离
    private int[] distance;

    public DijkstraGraph() {
        init();
        isMarked = new int[size];
        path = new String[size];
        distance = new int[size];

        for (int i = 0; i < size; i++) {
            path[i] = "";
            distance[i] = Integer.MAX_VALUE;
        }
    }

    public void search(int start) {
        int node = start;
        path[node] = nodes[node];
        do {
            findAdjacency(node);
            node = findShort();
        } while (node != -1);
    }

    /**
     * 扫描邻接点，记录邻接点权重值
     */
    private void findAdjacency(int node) {
        //标记中新点
        isMarked[node] = 1;
        System.out.println(path[node]);
        //扫邻接点
        for (int i = 0; i < size; i++) {
            if (edges[node][i] > 0) {
                //计算AA结点到i结点的权重值
                int dis = distance[node] + edges[node][i];
                if (dis < distance[i]) {
                    distance[i] = dis;
                    path[i] = path[node] + "->" + nodes[i];
                }
            }
        }
    }

    /**
     * 找出邻接点最小的权重
     *
     * @return
     */
    private int findShort() {
        int last = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (isMarked[i] == 1) {
                continue;
            }
            if (distance[i] < min) {
                min = distance[i];
                last = i;
            }
        }
        return last;
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
        edges[A][AA] = 3;
        edges[A][D] = 4;
        edges[B][AA] = 2;
        edges[B][C] = 2;
        edges[B][G] = 2;
        edges[B][E] = 3;
        edges[C][AA] = 5;
        edges[C][E] = 2;
        edges[C][B] = 2;
        edges[C][F] = 3;
        edges[D][A] = 4;
        edges[D][G] = 1;
        edges[E][B] = 3;
        edges[E][C] = 2;
        edges[E][F] = 2;
        edges[E][K] = 1;
        edges[E][H] = 3;
        edges[E][M] = 1;
        edges[F][C] = 3;
        edges[F][E] = 2;
        edges[F][K] = 4;
        edges[G][B] = 2;
        edges[G][D] = 1;
        edges[G][H] = 2;
        edges[H][G] = 2;
        edges[H][E] = 3;
        edges[K][E] = 1;
        edges[K][F] = 4;
        edges[K][N] = 2;
        edges[M][E] = 1;
        edges[M][N] = 3;
        edges[N][K] = 2;
        edges[N][M] = 3;
    }
}
