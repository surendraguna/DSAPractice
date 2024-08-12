package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphString {
    public static void main(String[] args) {
        Map<Character, List<Character>> map = new LinkedHashMap<>();
        map.putIfAbsent('A', new ArrayList<>());
        map.putIfAbsent('B', new ArrayList<>());
        map.putIfAbsent('C', new ArrayList<>());
        map.putIfAbsent('D', new ArrayList<>());
        map.putIfAbsent('E', new ArrayList<>());
        map.putIfAbsent('F', new ArrayList<>());
        map.putIfAbsent('G', new ArrayList<>());
        map.putIfAbsent('H', new ArrayList<>());
        map.get('A').addAll(Arrays.asList('B'));
        map.get('B').addAll(Arrays.asList('C', 'H'));
        map.get('C').addAll(Arrays.asList('D', 'E'));
        map.get('D').addAll(Arrays.asList('C'));
        map.get('E').addAll(Arrays.asList('C', 'F', 'G', 'H'));
        map.get('F').addAll(Arrays.asList('E'));
        map.get('G').addAll(Arrays.asList('E'));
        map.get('H').addAll(Arrays.asList('B', 'E'));
        List<Character> arr = new ArrayList<>();
        boolean[] visited = new boolean[map.size()];
        dfsTraversel(map, 'A', arr, visited);
        System.out.println(arr);
        bfsTraversel(map, 'A');
    }

    private static void bfsTraversel(Map<Character, List<Character>> map, char source) {
        ArrayList<Character> arr = new ArrayList<>();
        Queue<Character> q = new LinkedList<>();
        boolean visited[] = new boolean[map.size()];
        visited[source - 'A'] = true;
        q.add(source);
        while (!q.isEmpty()) {
            Character cur = q.poll();
            arr.add(cur);
            List<Character> temp = map.get(cur);
            for(char i : temp) {
                if(!visited[i - 'A']) {
                    visited[i - 'A'] = true;
                    q.add(i);
                }
            }
        }
        System.out.println(arr);
    }

    private static void dfsTraversel(Map<Character, List<Character>> map, char source, List<Character> arr, boolean[] visited) {
        arr.add(source);
        visited[source - 'A'] = true;
        List<Character> temp = map.get(source);
        for(char i : temp) if(!visited[i - 'A']) dfsTraversel(map, i, arr, visited);
    }
}
