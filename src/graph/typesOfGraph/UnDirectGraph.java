package graph.typesOfGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class UnDirectGraph <T> extends AbstractGraph <T>{

    public UnDirectGraph () {
        map = new TreeMap<>();
    }

    public Map<T, List<T>> getMap() {
        return map;
    }

    public void setMap(Map<T, List<T>> map) {
        this.map = map;
    }
   
    public void addEdge(T source, T destination) {
        map.putIfAbsent(source, new ArrayList<>());
        map.putIfAbsent(destination, new ArrayList<>());
        map.get(source).add(destination);
        map.get(destination).add(source);
    }

}
