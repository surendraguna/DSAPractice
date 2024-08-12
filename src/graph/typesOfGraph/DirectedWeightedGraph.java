package graph.typesOfGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DirectedWeightedGraph <T> extends AbstractGraph <T> {

    class Pair {
        T destination;
        int weight;
        Pair (T destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    Map<T, List<Pair>> map;

    public DirectedWeightedGraph () {
        map = new TreeMap<>();
    }
 
    public void addEdge(T source, T destination, int weight) {
        map.putIfAbsent(source, new ArrayList<>());
        map.putIfAbsent(destination, new ArrayList<>());
        map.get(source).add(new Pair(destination, weight));
    }    


    public void addEdge(T source, T destination) {
        addEdge(source, destination, 1);
    }

    public List<T> graphBFS(T source){
        super.setMap(withOutWeight());
        List<T> arr = super.graphBFS(source);
        return arr;
    }

    public List<T> graphDFS(T source){
        super.setMap(withOutWeight());
        List<T> arr = super.graphDFS(source);
        return arr;
    }


    public Map<T, List<T>> withOutWeight() {
        Map<T, List<T>> temp = new TreeMap<>();
        this.map.forEach((k, v) -> {
            List<T> dest = new ArrayList<>();
            for(Pair i : v) dest.add(i.destination);
            temp.put(k, dest);
        });
        return temp;
    }

    public List<T> topoLogicalSort() {
        setMap(withOutWeight());
        return super.topoLogicalSort();
    }
}