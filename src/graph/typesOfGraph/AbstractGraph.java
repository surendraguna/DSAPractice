package graph.typesOfGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public abstract class AbstractGraph <T> implements Graph <T>{
    
    protected Map<T, List<T>> map;

    public Map<T, List<T>> getMap() {
        return map;
    }

    public void setMap(Map<T, List<T>> map) {
        this.map = map;
    }

    public int size() {
        return map.size();
    }

    public List<T> graphBFS(T source){
        List<T> arr = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        Queue<T> q = new LinkedList<>();
        q.add(source);
        visited.add(source);
        while (!q.isEmpty()) {
            T cur = q.poll();
            List<T> temp = map.get(cur);
            arr.add(cur);
            if(temp != null) {
                for(T i : temp) {
                    if(!visited.contains(i)) {
                        visited.add(i);
                        q.add(i);
                    }
                }
            }
        }
        return arr;
    }

    public List<T> graphDFS(T source) {
        Set<T> visited = new HashSet<>();
        List<T> arr = new ArrayList<>();
        graphDFS(source, visited, arr);
        return arr;
    }

    private void graphDFS(T source, Set<T> visited, List<T> arr) {
        visited.add(source);
        arr.add(source);
        List<T> temp = map.get(source);
        if(temp != null) {
            for (T i : temp) {
                if(!visited.contains(i)) {
                    graphDFS(i, visited, arr);
                }
            }
        }
    }

    public List<T> topoLogicalSort() {
        List<T> arr = new ArrayList<>();
        Queue<T> q = new LinkedList<>();
        Map<T, Integer> inDegree = new HashMap<>();
        
        for(T i : map.keySet()) {
            inDegree.put(i, inDegree.getOrDefault(i, 0));
        }

        for(T i : map.keySet()) {
            for(T j : map.get(i)) {
                inDegree.put(j, inDegree.getOrDefault(j, 0) + 1);
            }
        }
        
        inDegree.forEach((k, v) -> {
            if(v == 0) q.add(k);
        });

        while (!q.isEmpty()) {
            T cur = q.poll();
            arr.add(cur);
            List<T> temp = map.get(cur);
            if(temp != null) {
                for(T i : temp) {
                    inDegree.put(i, inDegree.get(i) - 1);
                    if(inDegree.get(i) == 0) q.add(i);
                }
            }
        }

        return arr;
    }
}
