package leetcode.medium.broadfirstsearch;

import java.util.*;

/**
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

 Format
 The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

 You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

 Example 1:

 Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

 0
 |
 1
 / \
 2   3
 return [1]

 Example 2:

 Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

 0  1  2
 \ | /
 3
 |
 4
 |
 5
 return [3, 4]
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        // 寻找叶子节点：入度为1的节点

        int[][] e = new int[n][n];
        boolean[][] v = new boolean[n][n];
        for(int i = 0; i<edges.length; i++) {
            e[edges[i][0]][edges[i][1]] = 1;
            e[edges[i][1]][edges[i][0]] = 1;
        }
        for(int i = 0; i<n; i++) {
            LinkedList<Integer> q = new LinkedList<Integer>();
            q.offer(i);
            while(!q.isEmpty()) {
                int vertex = q.poll();

            }
        }
        return res;
    }
}
