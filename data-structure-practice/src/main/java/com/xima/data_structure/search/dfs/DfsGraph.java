package com.xima.data_structure.search.dfs;

import java.util.LinkedList;

public class DfsGraph {
    /**
     * 无向图
     */
    private int v; // 顶点的个数
    private LinkedList<Integer> adj[]; // 邻接表

    public DfsGraph(int v) {
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
     * 深度优先搜索用的是一种比较著名的算法思想，回溯思想
     *
     */
    boolean found = false; // 全局变量或者类成员变量

    public void dfs(int s, int t) {
        /**
         * 初始化 visited，queue，prev
         */
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        /**
         * 广度优先搜索 Breadth-First-Search
         * 回溯思想, 利用递归
         */
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true) return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
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
         * 构建一个无向图 如图：深度优先搜索Depth-First-Search.jpg
         */
        DfsGraph dfsGraph = new DfsGraph(9);
        dfsGraph.addEdge(1,2);
        dfsGraph.addEdge(1,4);
        dfsGraph.addEdge(2,3);
        dfsGraph.addEdge(2,5);
        dfsGraph.addEdge(3,6);
        dfsGraph.addEdge(4,5);
        dfsGraph.addEdge(5,6);
        dfsGraph.addEdge(5,7);
        dfsGraph.addEdge(6,8);
        dfsGraph.addEdge(7,8);

        /**
         * 递归
         */
        dfsGraph.dfs(1,7);
    }



}