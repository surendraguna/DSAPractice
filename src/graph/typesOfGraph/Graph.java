package graph.typesOfGraph;

import java.util.List;

public interface Graph <T> {
    int size();
    List<T> graphBFS(T source);
    List<T> graphDFS(T source);
    void addEdge(T source, T destination);
} 
