package chapter6;

import java.util.*;

public class Prims {
    int adj[][];
    boolean[] found;
    int[] key;
    int[] parents;
    int verts;

    int INF = 99999;

    public Prims(int[][] adj, int n) {
        verts = n;
        adj = new int[n][n];
        key = new int[n];
        parents = new int[n];
        found = new boolean[n];
        for(int i = 0; i < n; i++) {
            key[i] = INF;
            found[i] = false;

            for(int j = 0; j < n; j++) {
                this.adj[i][j] = adj[i][j];
            }
        }
    }

    public void fillMST(int vertex) {
        key[vertex] = 0;
        for(int i = 0; i < verts - 1; i++) {
            int u = getMin();
            found[u] = true;
            for(int j = 0; j < verts; j++) {
                if(adj[u][j] != 0 && !found[j] && adj[u][j] < key[j]) {
                    key[j] = adj[u][j];
                    parents[j] = u;
                }
            }
        }
    }

    public int getMin() {
        int minI = -1;
        int minVal = INF;
        for(int i = 0; i < verts; i++) {
            if(!found[i] && minVal <= key[i]) {
                minI = i;
                minVal = key[i];
            }
        }

        return minI;
    }

    void print(){
        int total = 0;
        for(int i = 0;i < verts;++i){
            System.out.println(i+" - "+parents[i]);
            total += adj[i][parents[i]];
        }
        System.out.println("The total cost is : "+total);
    }

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the no of vertices : ");
        int n = s.nextInt();
        int a[][] = new int[n][n];
        System.out.println("Enter the adjacency matrix");
        for(int i = 0;i < n;++i)
            for(int j = 0;j < n;++j)
                a[i][j] = s.nextInt();
        Prims p = new Prims(a,n);
        p.fillMST(0);
        System.out.println("The edges of the MST are ");
        p.print();
    }
}