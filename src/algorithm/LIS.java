package algorithm;

public class LIS {
    public static void main(String[] args) {
        System.out.println(helper(new int[]{0,1,0,3,2,3}, 0, -1));
    }

    static int helper(int a[], int i, int prev) {
        if(i == a.length) return 0;
        int notpick = 0 + helper(a, i + 1, prev);
        int pick = 0;
        if(a[i] > prev) pick = 1 + helper(a, i + 1, a[i]);
        return Math.max(notpick, pick);
    }
}
