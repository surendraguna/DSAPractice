package graph;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Topo {
    public static void main(String[] args) {
        int[][] gp = {
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0}
        };
        topo(gp);
        List<List<Integer>> g = new ArrayList<>();
        g.add(new ArrayList<>(Arrays.asList(1, 2)));
        g.add(new ArrayList<>(Arrays.asList()));
        g.add(new ArrayList<>(Arrays.asList(1, 5)));
        g.add(new ArrayList<>(Arrays.asList(0, 4)));
        g.add(new ArrayList<>(Arrays.asList(2)));
        g.add(new ArrayList<>(Arrays.asList(1)));
        topo(g);
    }

    private static void topo(List<List<Integer>> g) {
        int[] inDeg = new int[g.size()];
        for(int i = 0; i < g.size(); i++) 
            for (int j : g.get(i)) 
                inDeg[j]++;        
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < inDeg.length; i++) 
            if(inDeg[i] == 0)
                q.add(i);
        while (!q.isEmpty()) {
            int cur = q.poll();
            arr.add(cur);
            List<Integer> temp = g.get(cur);
            for(int i : temp) {
                inDeg[i]--;
                if(inDeg[i] == 0) q.add(i);
            }
        }
        System.out.println(arr);
    }

    static void topo (int[][] gp) {
        int[] inDeg = new int[gp.length];
        for(int i = 0; i < gp.length; i++) 
            for(int j = 0; j < gp[i].length; j++)
                if(gp[i][j] == 1) inDeg[j]++;
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < inDeg.length; i++) if(inDeg[i] == 0) q.add(i);
        while(!q.isEmpty()) {
            int cur = q.poll();
            arr.add(cur);
            for(int i = 0; i < gp[cur].length; i++) {
                if(gp[cur][i] == 1) {
                    inDeg[i]--;
                    if(inDeg[i] == 0) q.add(i);
                }
            }
        }
        System.out.println(arr);
    }
}