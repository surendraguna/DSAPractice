package graph;

import graph.typesOfGraph.DirectedWeightedGraph;

public class Practice {
    public static void main(String[] args) {
           
        DirectedWeightedGraph<Integer> gp = new DirectedWeightedGraph<>();
        gp.addEdge(0, 1);
        gp.addEdge(0, 2);
        gp.addEdge(2, 1);
        gp.addEdge(2, 5);
        gp.addEdge(3, 0);
        gp.addEdge(3, 4);
        gp.addEdge(4, 2);
        gp.addEdge(5, 1);
    
        System.out.println(gp.topoLogicalSort());

    }
}
