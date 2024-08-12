package graph;

public class StrassensMatrix {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        int p = (a[0][0] + a[1][1]) * (b[0][0] + b[1][1]);
        int q = (a[1][0] + a[1][1]) * b[0][0];
        int r = a[0][0] * (b[0][1] - b[1][1]);
        int s = a[1][1] * (b[1][0] - b[0][0]);
        int t = (a[0][0] + a[0][1]) * b[1][1];
        int u = (a[1][0] -  a[0][0]) * (b[0][0] + b[0][1]);
        int v = (a[0][1] - a[1][1]) * (b[1][0] + b[1][1]);
        int[][] c = new int[a.length][a.length];
        c[0][0] = p + s - t + v;
        c[0][1] = r + t;
        c[1][0] = q + s;
        c[1][1] = p + r - q + u;
        for(int[] i : c) {
            System.out.println(i[0] + " " + i[1]);
        } 
    }
}
