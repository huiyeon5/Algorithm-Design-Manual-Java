package chapter5;

import java.util.*;

public class GraphList {
    private LinkedList<Integer> graph[];

    public GraphList(int max) {
        graph = new LinkedList[max];
        for(int i = 0; i < max; i++) {
            graph[i] = new LinkedList<>();
        }
    }

    public void add(int src, int dest) {
        graph[src].add(dest);

        // graph[dest].add(src) IF IT IS UNDIRECTED
    }

    public void breadthFirst(int start) {
        boolean[] visited = new boolean[graph.length];

        LinkedList<Integer> queue = new LinkedList<>();
        visited[start] = true;

        queue.add(start);

        while(!queue.isEmpty()) {
            int val = queue.poll();
            System.out.print(val + " ");

            ListIterator<Integer> iter = graph[val].listIterator();
            while(iter.hasNext()) {
                int n = iter.next();
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public void depthFirst(int val) {
        boolean[] visited = new boolean[graph.length];
        DFSUtil(val, visited);
    }

    public void DFSUtil(int val, boolean[] visited) {
        visited[val] = true;
        System.out.print(val + " ");

        Iterator<Integer> iter = graph[val].listIterator();
        while(iter.hasNext()) {
            int n = iter.next();
            if(!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }
}