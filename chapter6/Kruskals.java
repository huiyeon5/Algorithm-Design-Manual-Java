package chapter6;

public class Kruskals {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge anotherEdge) {
            return weight - anotherEdge.weight;
        }
    }

    //FOR UNION FIND ALGO
    class Subset {
        int parent, rank;
    }

    int V, E;
    Edge[] edge;

    Kruskals(int v, int e) {
        V = v;
        E = e;

        for(int i = 0; i < E; i++) {
            edge[i] = new Edge();
        }
    }

    int find(Subset[] subsets, int x) {
        if(subsets[x].parent != x) {
            subsets[x].parent = find(subsets, subsets[x].parent);
        }

        return subsets[x].parent;
    }

    void union(Subset[] subsets, int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        if(subsets[xRoot].rank < subsets[yRoot].rank) {
            subsets[xRoot].parent = yRoot;
        } else if(subsets[xRoot].rank > subsets[yRoot].rank) {
            subsets[yRoot].parent = xRoot;
        } else {
            subsets[yroot].parent = xroot; 
            subsets[xroot].rank++; 
        }
    }

    void fillKruskal() {
        Edge[] result = new Edge[V];
        int e = 0;
        int i = 0;
        for(i = 0; i < V; i++) {
            result[i] = new Edge();
        }

        Arrays.sort(edge);

        Subset[] subsets = new Subset[V];
        for(i = 0; i < V; i++) {
            subset[i] = new Subset();
        }

        for (int v = 0; v < V; ++v) { 
            subsets[v].parent = v; 
            subsets[v].rank = 0; 
        } 

        i = 0;
        while(e < V - 1) {
            Edge minEdge = new Edge();
            minEdge = edge[i++];

            int x = find(subsets, minEdge.src);
            int y = find(subsets, minEdge.dest);

            if(x != y) {
                result[e++] = minEdge;
                union(subsets, x, y);
            }
        }

        System.out.println("Following are the edges in " +  
                                     "the constructed MST"); 
        for (i = 0; i < e; ++i) 
            System.out.println(result[i].src+" -- " +  
                   result[i].dest+" == " + result[i].weight); 
    }

    public static void main (String[] args) { 

        int V = 4;  // Number of vertices in graph 
        int E = 5;  // Number of edges in graph 
        Kruskals graph = new Kruskals(V, E); 
  
        // add edge 0-1 
        graph.edge[0].src = 0; 
        graph.edge[0].dest = 1; 
        graph.edge[0].weight = 10; 
  
        // add edge 0-2 
        graph.edge[1].src = 0; 
        graph.edge[1].dest = 2; 
        graph.edge[1].weight = 6; 
  
        // add edge 0-3 
        graph.edge[2].src = 0; 
        graph.edge[2].dest = 3; 
        graph.edge[2].weight = 5; 
  
        // add edge 1-3 
        graph.edge[3].src = 1; 
        graph.edge[3].dest = 3; 
        graph.edge[3].weight = 15; 
  
        // add edge 2-3 
        graph.edge[4].src = 2; 
        graph.edge[4].dest = 3; 
        graph.edge[4].weight = 4; 
  
        graph.fillKruskal(); 
    } 
}