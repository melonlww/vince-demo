package com.xima.data_structure.search.dfs;

import com.xima.data_structure.search.Graph;

import java.util.LinkedList;

/**
 * 深度优先搜索用的是一种比较著名的算法思想，回溯思想
 */
public class DfsSearch {
    // 全局变量或者类成员变量
    boolean found = false;

    public void dfs(Graph graph, int s, int t) {
        int v = graph.getV();
        LinkedList<Integer>[] adj = graph.getAdj();
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
        recurDfs(adj, s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(LinkedList<Integer>[] adj, int w, int t, boolean[] visited, int[] prev) {
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
                recurDfs(adj, q, t, visited, prev);
            }
        }
    }

    // 递归打印s->t的路径
    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    public static void main(String[] args) {
        /**
         * 构建一个无向图 如图：深度优先搜索Depth-First-Search.jpg
         */
        Graph graph = new Graph(9);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);
        graph.addEdge(7, 8);

        /**
         * 递归
         */
        DfsSearch dfsSearch = new DfsSearch();
        dfsSearch.dfs(graph, 1, 7);
    }


}