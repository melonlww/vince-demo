package com.xima.data_structure.search.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BfsGraph {
    /**
     * 无向图
     */
    private int v; // 顶点的个数
    private LinkedList<Integer> adj[]; // 邻接表

    public BfsGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // 无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先搜索 Breadth-First-Search
     *
     * visited 是用来记录已经被访问的顶点，用来避免顶点被重复访问。如果顶点 q 被访问，那相应的 visited[q]会被设置为 true。
     *
     * queue 是一个队列，用来存储已经被访问、但相连的顶点还没有被访问的顶点。因为广度优先搜索是逐层访问的，也就是说，我们只有把
     * 第 k 层的顶点都访问完成之后，才能访问第 k+1 层的顶点。当我们访问到第 k 层的顶点的时候，我们需要把第 k 层的顶点记录下来，
     * 稍后才能通过第 k 层的顶点来找第 k+1 层的顶点。所以，我们用这个队列来实现记录的功能。
     *
     * prev 用来记录搜索路径。当我们从顶点 s 开始，广度优先搜索到顶点 t 后，prev 数组中存储的就是搜索的路径。不过，这个路径是
     * 反向存储的。prev[w]存储的是，顶点 w 是从哪个前驱顶点遍历过来的。比如，我们通过顶点 2 的邻接表访问到顶点 3，那 prev[3]
     * 就等于 2。为了正向打印出路径，我们需要递归地来打印，你可以看下 print() 函数的实现方式。
     *
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
        if (s == t) return;
        /**
         * 初始化 visited，queue，prev
         */
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }

        /**
         * 遍历节点
         * 直观地讲，它其实就是一种“地毯式”层层推进的搜索策略，即先查找离起始顶点最近的，然后是次近的，依次往外搜索。
         */
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    public static void main(String[] args) {
        /**
         * 构建一个无向图 如图：广度优先搜索Breadth-First-Search.jpg
         */
        BfsGraph bfsGraph = new BfsGraph(8);
        bfsGraph.addEdge(0,1);
        bfsGraph.addEdge(0,3);
        bfsGraph.addEdge(1,2);
        bfsGraph.addEdge(1,4);
        bfsGraph.addEdge(3,4);
        bfsGraph.addEdge(2,5);
        bfsGraph.addEdge(4,5);
        bfsGraph.addEdge(4,6);
        bfsGraph.addEdge(5,7);
        bfsGraph.addEdge(6,7);
        /**
         * 用广度优先搜索 Breadth-First-Search，打印两个节点间的最短路径
         */
        bfsGraph.bfs(0,7);
    }
}