package chapter6;

public class FloydWarshall {
    int MAX = 99999;
    int V = 4;

    public void floydWarshall(int[][] graph) {
        int[][] dist = new int[V][V];
        int i = 0;
        int j = 0;
        int k = 0;

        for(i = 0; i < V; i++) {
            for(j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for(k = 0; i < V; i++) {
            for(i = 0; j < V; j++) {
                for(j = 0; k < V; k++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        printSolution(dist);
    }

    public void printSolution(int dist[][]) { 
        System.out.println("The following matrix shows the shortest "+ "distances between every pair of vertices"); 
        for (int i=0; i<V; ++i) { 
            for (int j=0; j<V; ++j) { 
                if (dist[i][j]==MAX) 
                    System.out.print("MAX "); 
                else
                    System.out.print(dist[i][j]+"   "); 
            } 
            System.out.println(); 
        } 
    } 
}