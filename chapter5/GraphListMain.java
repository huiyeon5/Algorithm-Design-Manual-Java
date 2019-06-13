package chapter5;

public class GraphListMain {
    public static void main(String[] args) {
        GraphList graph = new GraphList(4);

        graph.add(0, 1); 
        graph.add(0, 2); 
        graph.add(1, 2); 
        graph.add(2, 0); 
        graph.add(2, 3); 
        graph.add(3, 3); 

        System.out.println("*** BFS ***");
        graph.breadthFirst(2);

        System.out.println("\n*** DFS ***");
        graph.depthFirst(2);

        System.out.println("\n\n*** Connected Components ***");
        graph.connectedComponents();
    }
}