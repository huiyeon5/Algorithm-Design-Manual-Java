package chapter6;

public class Dijkstras {
    int[][] adj;
    int verts;
    int[] dist;
    int[] parents;
    boolean[] found;
    int MAX = 99999;

    public Dijkstras(int[][] adj, int verts) {
        this.verts = verts;
        dist = new int[verts];
        parents = new int[verts];
        found = new boolean[verts];

        for(int i = 0; i < verts; i++) {
            dist[i] = MAX;
            found = false;
            
            for(int j = 0; j < verts; j++) {
                this.adj[i][j] = adj[i][j];
            }
        }
    }

    //Gets all the shortest path from the "start"
    public void getShortestPath(int start) {
        dist[start] = 0;

        for(int i = 0; i < verts - 1; i++) {
            int u = getMin();
            found[u] = true;

            for(int j = 0; j < verts; j++) {
                if(adj[u][j] != 0 && dist[j] > dist[u] + adj[u][j]) {
                    dist[j] = dist[u] + adj[u][j];
                    parent[j] = u;
                }
            }
        }
    }

    public int getMin() {
        int minI = -1;
        int minVal = MAX;

        for(int i = 0; i < verts; i++) {
            if(!found[i] && minVal > dist[i]) {
                minVal = dist[i];
                minI = i;
            }
        }

        return minI;
    }
}