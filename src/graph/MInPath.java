package graph;

import java.util.LinkedList;
import java.util.Queue;

public class MInPath {
    public static void main(String[] args) {
        int[][] a = {{1,2,9},{2,3,6},{2,4,5},{1,4,7}};
        System.out.println(minScore(4, a));
    }

    public static int minScore(int n, int[][] roads) {
        int[][] gp = new int[n][n];
        for(int i = 0; i < roads.length; i++) {
            gp[roads[i][0] - 1][roads[i][1] - 1] = roads[i][2];
            gp[roads[i][1] - 1][roads[i][0] - 1] = roads[i][2];  
        }
        return bfs(gp, 0);
    }

    private static int bfs(int[][] graph, int source) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        boolean[] visited = new boolean[graph.length];
        visited[source] = true;
        int res = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for(int i = 0; i < graph[cur].length; i++) {
                if(graph[cur][i] != 0 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
                res = Math.min(graph[cur][i], res);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
