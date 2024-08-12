package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Representation {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int v = inp.nextInt();
        int e = inp.nextInt();
        // int[][] g = new int[v][v];
        // for(int i = 0; i < e; i++) {
        //     int sv = inp.nextInt();
        //     int ev = inp.nextInt();
        //     g[sv][ev] = g[ev][sv] = 1;
        // }
        // for(int i = 0; i < g.length; i++) {
        //     for(int j = 0; j < g[i].length; j++) System.out.print(g[i][j] + " ");
        //     System.out.println();
        // }
        List<List<Integer>> gp = new ArrayList<>();
        for(int i = 0; i < v; i++) {
            gp.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            int sv = inp.nextInt();
            int ev = inp.nextInt();
            gp.get(sv).add(ev);
            gp.get(ev).add(sv);
        }

        for(List<Integer> a : gp) {
            for(int i : a) System.out.print(i + " ");
            System.out.println();
        }
        inp.close();    
        
    }
}
