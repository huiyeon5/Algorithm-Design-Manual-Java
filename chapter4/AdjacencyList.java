package chapter4;

public class AdjacencyList {
    private LinkedList<Integer>[] list;
    private boolean directed;

    public AdjacencyList(int maxV, boolean directed) {
        list = new LinkedList<>()[maxV];
        this.directed = directed;

        for(LinkedList<Integer> item : list) {
            item = new LinkedList<>();
        }
    }

    public void insertEdge(int src, int dest) {
        if(src >= 0 && src < list.length) {
            list[src].add(dest);
            if(directed) {
                list[dest].add(src);
            }
        } else {
            System.out.println("SRC out of BOUNDS");
        }
    }
}