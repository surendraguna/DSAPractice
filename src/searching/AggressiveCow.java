package searching;

import java.util.*;

public class AggressiveCow {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int c = s.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < a.length; i++)
                a[i] = s.nextInt();
            Arrays.sort(a);
            int l = 0, r = a[a.length - 1];
            while (l <= r) {
                int m = (l + r) >>> 1;
                if(isPossible(a, c, m)) l = m + 1;
                else r = m - 1; 
            }
            System.out.println(r);
        }
        s.close();
    }

    private static boolean isPossible(int[] s, int c, int m) {
        int pre = s[0];
        int cowsPlaced = 1;
        for(int i = 1; i < s.length; i++){
            if(s[i] - pre >= m){
                cowsPlaced++;
                pre = s[i];
            }
        }
        return cowsPlaced >= c;
    }
}
